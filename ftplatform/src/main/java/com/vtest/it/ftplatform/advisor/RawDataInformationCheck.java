package com.vtest.it.ftplatform.advisor;

import com.vtest.it.common.pojo.RawDataFtBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Aspect
@Component
public class RawDataInformationCheck {
    @Around(value = "execution(* com.vtest.it.ftplatform.service.rawdataTools.RawdataTxtGenerate.generateTxt(..))")
    public void check(ProceedingJoinPoint proceedingJoinPoint){
        try {
            //RawDataFtBean rawDataFtBean, List<String> dieList, Map<Integer, Integer> binSummary, Map<Integer, Integer> SoftBinSummary,
//            proceedingJoinPoint.getArgs();
            proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
