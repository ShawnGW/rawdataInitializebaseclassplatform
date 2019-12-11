package com.vtest.it.common.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FtStdfInitialBean implements Serializable {
    private static final long serialVersionUID=1l;
    private String lotId;
    private String ftStep;
    private String operator;
    private String dataBase;
    private String testStartTime;
    private String testEndTime;
    private List<String> testDies;

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getFtStep() {
        return ftStep;
    }

    public void setFtStep(String ftStep) {
        this.ftStep = ftStep;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getTestStartTime() {
        return testStartTime;
    }

    public void setTestStartTime(String testStartTime) {
        this.testStartTime = testStartTime;
    }

    public String getTestEndTime() {
        return testEndTime;
    }

    public void setTestEndTime(String testEndTime) {
        this.testEndTime = testEndTime;
    }

    public List<String> getTestDies() {
        return testDies;
    }

    public void setTestDies(List<String> testDies) {
        this.testDies = testDies;
    }
}
