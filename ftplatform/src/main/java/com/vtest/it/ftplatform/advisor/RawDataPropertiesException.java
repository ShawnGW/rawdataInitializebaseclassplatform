package com.vtest.it.ftplatform.advisor;

import com.vtest.it.common.pojo.RawDataFtBean;
import com.vtest.it.ftplatform.pojo.vtftmt.DataParseIssueBean;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class RawDataPropertiesException {
    @AfterThrowing(pointcut = "execution(* com.vtest.it.ftplatform.service.rawdataTools.RawDataPropertiesInitial.initial(..))&&args(rawDataFtBean)", throwing = "e")
    public void deal(RawDataFtBean rawDataFtBean, Exception e) {
        DataParseIssueBean dataParseIssueBean;
    }
}
