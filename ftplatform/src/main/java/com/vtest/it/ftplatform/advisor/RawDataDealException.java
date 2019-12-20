package com.vtest.it.ftplatform.advisor;

import com.vtest.it.common.pojo.FtStdfInitialBean;
import com.vtest.it.common.pojo.RawDataFtBean;
import com.vtest.it.ftplatform.pojo.vtftmt.DataParseIssueBean;
import com.vtest.it.ftplatform.service.VtftmtService;
import com.vtest.it.ftplatform.service.issuebeanbuilder.IssueBeanBuilderByFtInitialBean;
import com.vtest.it.ftplatform.service.issuebeanbuilder.IssueBeanBuilderByRawDataBean;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Aspect
@Component
public class RawDataDealException {

    @Autowired
    private VtftmtService vtftmtService;

    @Pointcut(value = "execution(* com.vtest.it.ftplatform.service.rawdataTools.RawDataDeal.deal(..))")
    private void rawDataGenerateExceptionAdvisor() {
    }

    @AfterThrowing(value = "rawDataGenerateExceptionAdvisor()&&args(bean,rawDataFtBean))", throwing = "e")
    public void deal(FtStdfInitialBean bean, RawDataFtBean rawDataFtBean, Exception e) {
        DataParseIssueBean dataParseIssueBean;
        if (null!=rawDataFtBean){
            dataParseIssueBean=new IssueBeanBuilderByRawDataBean(rawDataFtBean,"Runtime exception","unknow").getDataParseIssueBean();
        }else {
            dataParseIssueBean=new IssueBeanBuilderByFtInitialBean(bean,"Properties error","miss lot or ft step").getDataParseIssueBean();
        }
        vtftmtService.logError(dataParseIssueBean);
    }

    @Before(value = "rawDataGenerateExceptionAdvisor()&&args(bean,rawDataFtBean)")
    public void errorBinDeal(FtStdfInitialBean bean, RawDataFtBean rawDataFtBean) {
        if (null == rawDataFtBean) {
            return;
        }
        List<String> testDies = bean.getTestDies();
        Iterator<String> iterator = testDies.iterator();
        String[] osBins = rawDataFtBean.getOsBins().split(",");
        String firstOsBin = osBins[0];
        List<String> listAfterModify = new LinkedList<>();
        while (iterator.hasNext()) {
            String die = iterator.next();
            String[] tokens = die.split(":");
            String hardBin = tokens[0];
            String softBin = tokens[1];
            String site = tokens[2];
            if (hardBin.length() > 4 || softBin.length() > 4) {
                testDies.remove(die);
            }
            listAfterModify.add(firstOsBin + ":" + firstOsBin + ":" + site);
        }
        testDies.addAll(listAfterModify);
    }
}