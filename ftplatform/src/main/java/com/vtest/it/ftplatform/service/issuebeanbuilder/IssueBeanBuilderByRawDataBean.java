package com.vtest.it.ftplatform.service.issuebeanbuilder;

import com.vtest.it.common.pojo.RawDataFtBean;

public class IssueBeanBuilderByRawDataBean extends AbstractIssueBeanBuilder {

    private RawDataFtBean rawDataFtBean;
    private String issueType;
    private String issueDescription;

    public IssueBeanBuilderByRawDataBean(RawDataFtBean rawDataFtBean, String issueType, String issueDescription) {
        this.rawDataFtBean = rawDataFtBean;
        this.issueType = issueType;
        this.issueDescription = issueDescription;
        setCustomCode();
        setDevice();
        setLotId();
        setFtStep();
        setResource();
        setIssueType();
        setIssuLevel();
        setIssuePath();
        setIssueDescription();
        setDealFlag();
    }

    @Override
    public void setCustomCode() {
        dataParseIssueBean.setCustomCode(rawDataFtBean.getCustomerCode());
    }

    @Override
    public void setDevice() {
        dataParseIssueBean.setDevice(rawDataFtBean.getDeviceName());
    }

    @Override
    public void setLotId() {
        dataParseIssueBean.setLotId(rawDataFtBean.getLotId());
    }

    @Override
    public void setFtStep() {
        dataParseIssueBean.setFtStep(rawDataFtBean.getFtProcess());
    }

    @Override
    public void setResource() {
        dataParseIssueBean.setResource(rawDataFtBean.getDataBase());
    }

    @Override
    public void setIssueType() {
        dataParseIssueBean.setIssueType(issueType);
    }

    @Override
    public void setIssuLevel() {
        dataParseIssueBean.setIssuLevel(5);
    }

    @Override
    public void setIssuePath() {
        dataParseIssueBean.setIssuePath("it was transformed by stdf,please check stdf in Data directory");
    }

    @Override
    public void setIssueDescription() {
        dataParseIssueBean.setIssueDescription(issueDescription);
    }

    @Override
    public void setDealFlag() {
        dataParseIssueBean.setDealFlag(0);
    }
}
