package com.vtest.it.ftplatform.service.rawdataTools;

import com.vtest.it.common.pojo.FtStdfInitialBean;
import com.vtest.it.common.pojo.RawDataFtBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RawDataDeal {

    @Autowired
    private RawdataTxtGenerate rawdataTxtGenerate;

    public void deal(FtStdfInitialBean bean, RawDataFtBean rawDataFtBean) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);
        rawDataFtBean.setTestStartTime(format.parse(bean.getTestStartTime()));
        rawDataFtBean.setTestEndTime(format.parse(bean.getTestEndTime()));
        rawDataFtBean.setOperator(bean.getOperator());
        rawDataFtBean.setDataBase(bean.getDataBase());
        rawDataFtBean.setFtProcess(bean.getFtStep());
        rawDataFtBean.setTestTime("" + (format.parse(bean.getTestEndTime()).getTime() - format.parse(bean.getTestStartTime()).getTime()) / 1000);
        List<String> testDies = bean.getTestDies();
        String[] passBins = rawDataFtBean.getPassBins().split(",");
        List<String> passBinList = new ArrayList<>();
        List<String> dieList = new LinkedList<>();
        Map<Integer, Integer> binSummary = new TreeMap<>();
        Map<Integer, Integer> softBinSummary = new TreeMap<>();
        for (String passBin : passBins) {
            passBinList.add(passBin);
        }
        int passDieCount = 0;
        int failDieCount = 0;
        for (String testDie : testDies) {
            String[] tokens = testDie.split(":");
            String hardBin = tokens[0];
            String softBin = tokens[1];
            String site = tokens[2];
            Integer hardBinNumber = Integer.valueOf(hardBin);
            Integer softBinNumber = Integer.valueOf(softBin);
            if (binSummary.containsKey(hardBinNumber)) {
                binSummary.put(hardBinNumber, binSummary.get(hardBinNumber) + 1);
            } else {
                binSummary.put(hardBinNumber, 1);
            }
            if (softBinSummary.containsKey(softBinNumber)) {
                softBinSummary.put(softBinNumber, softBinSummary.get(softBinNumber) + 1);
            } else {
                softBinSummary.put(softBinNumber, 1);
            }

            if (passBinList.contains(hardBin)) {
                passDieCount++;
            } else {
                failDieCount++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("%4s", "0"));
            stringBuilder.append(String.format("%4s", "0"));
            stringBuilder.append(String.format("%4s", hardBin));
            stringBuilder.append(String.format("%4s", softBin));
            stringBuilder.append(String.format("%4s", site));
            dieList.add(stringBuilder.toString());
        }
        rawDataFtBean.setPassDie(passDieCount);
        rawDataFtBean.setFailDie(failDieCount);
        rawDataFtBean.setLotYield(((double) passDieCount) / (passDieCount + failDieCount));
        rawdataTxtGenerate.generateTxt(rawDataFtBean, dieList, binSummary, softBinSummary);
    }
}
