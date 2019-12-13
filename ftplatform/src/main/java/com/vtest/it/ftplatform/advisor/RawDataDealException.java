package com.vtest.it.ftplatform.advisor;

import com.vtest.it.common.pojo.RawDataFtBean;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RawDataDealException {

    @Pointcut(value = "execution(* com.vtest.it.ftplatform.service.rawdataTools.RawDataDeal.deal(..))")
    private void rawDataGenerateExceptionAdvisor(){};

    @AfterThrowing(value = "rawDataGenerateExceptionAdvisor()&&(args(rawDataFtBean,..)||args(..,rawDataFtBean))",throwing = "e")
    public void deal(RawDataFtBean rawDataFtBean, Exception e){
        //
    }
}
