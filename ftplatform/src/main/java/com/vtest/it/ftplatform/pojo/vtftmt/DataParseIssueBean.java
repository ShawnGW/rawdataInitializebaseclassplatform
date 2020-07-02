package com.vtest.it.ftplatform.pojo.vtftmt;

import java.io.Serializable;

public class DataParseIssueBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String customCode;
    private String device;
    private String lotId;
    private String ftStep;
    private String resource;
    private String issueType;
    private int issuLevel;
    private String issuePath;
    private String issueDescription;
    private int dealFlag;

    public String getCustomCode() {
        return customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public int getIssuLevel() {
        return issuLevel;
    }

    public void setIssuLevel(int issuLevel) {
        this.issuLevel = issuLevel;
    }

    public String getIssuePath() {
        return issuePath;
    }

    public void setIssuePath(String issuePath) {
        this.issuePath = issuePath;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public int getDealFlag() {
        return dealFlag;
    }

    public void setDealFlag(int dealFlag) {
        this.dealFlag = dealFlag;
    }
}
