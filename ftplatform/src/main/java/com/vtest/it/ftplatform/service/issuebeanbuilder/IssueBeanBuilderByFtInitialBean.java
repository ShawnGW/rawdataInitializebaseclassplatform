package com.vtest.it.ftplatform.service.issuebeanbuilder;

import com.vtest.it.common.pojo.FtStdfInitialBean;

public class IssueBeanBuilderByFtInitialBean extends AbstractIssueBeanBuilder {

    private FtStdfInitialBean rawDataFtBean;
    private String issueType;
    private String issueDescription;

    public IssueBeanBuilderByFtInitialBean(FtStdfInitialBean rawDataFtBean, String issueType, String issueDescription) {
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
        dataParseIssueBean.setCustomCode("NA");
    }

    @Override
    public void setDevice() {
        dataParseIssueBean.setDevice("NA");
    }

    @Override
    public void setLotId() {
        dataParseIssueBean.setLotId(rawDataFtBean.getLotId());
    }

    @Override
    public void setFtStep() {
        dataParseIssueBean.setFtStep(rawDataFtBean.getFtStep());
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
        dataParseIssueBean.setIssueType("it was transformed by stdf,please check stdf in Data directory");
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
