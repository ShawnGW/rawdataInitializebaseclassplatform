package com.vtest.it.ftstdfparse.service.stdfparse;

import com.vtest.it.common.pojo.FtStdfInitialBean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FtStdfParse {
    public FtStdfInitialBean parse(File file) throws IOException {
        FtStdfInitialBean ftStdfInitialBean = new FtStdfInitialBean();
        boolean flag = false;
        String lotId = null;
        String operator = null;
        String testStartTime = null;
        String testEndTime = null;
        String stdfProgram = null;
        FileReader in = new FileReader(file);
        BufferedReader reader = new BufferedReader(in);
        String content = null;
        String siteNumber = null;
        String hardBin = null;
        String softBin;
        List<String> dieList = new ArrayList<>(10000);
        while ((content = reader.readLine()) != null) {
            if (content.equals("PRR Record")) {
                flag = true;
                continue;
            }
            if (flag) {
                if (content.contains("SOFT_BIN")) {
                    softBin = content.trim().split(":")[1].trim();
                    flag = false;
                    dieList.add(hardBin + ":" + softBin + ":" + siteNumber);
                    continue;
                }
                if (content.contains("SITE_NUM")) {
                    siteNumber = content.trim().split(":")[1].trim();
                    continue;
                }
                if (content.contains("HARD_BIN")) {
                    hardBin = content.trim().split(":")[1].trim();
                }
            } else {
                if (content.contains("JOB_NAM")) {
                    stdfProgram = content.trim().split(":")[1].trim();
                    continue;
                }
                if (content.contains("START_T")) {
                    String time = content.trim();
                    testStartTime = time.substring(time.indexOf("(") + 1, time.indexOf(")"));
                    continue;
                }
                if (content.contains("FINISH_T")) {
                    String time = content.trim();
                    testEndTime = time.substring(time.indexOf("(") + 1, time.indexOf(")"));
                    break;
                }
            }
        }
        in.close();
        reader.close();
        ftStdfInitialBean.setLotId(lotId);
        ftStdfInitialBean.setOperator(operator);
        ftStdfInitialBean.setDataBase("STDF");
        ftStdfInitialBean.setTestStartTime(testStartTime);
        ftStdfInitialBean.setTestEndTime(testEndTime);
        ftStdfInitialBean.setTestDies(dieList);
        ftStdfInitialBean.setStdfProgram(stdfProgram);
        return ftStdfInitialBean;
    }
}
