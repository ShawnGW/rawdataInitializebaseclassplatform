package com.vtest.it.ftplatform.service.issuebeanbuilder;

import com.vtest.it.ftplatform.pojo.vtftmt.DataParseIssueBean;

public abstract class AbstractIssueBeanBuilder {
    protected DataParseIssueBean dataParseIssueBean = new DataParseIssueBean();

    public abstract void setCustomCode();

    public abstract void setDevice();

    public abstract void setLotId();

    public abstract void setFtStep();

    public abstract void setResource();

    public abstract void setIssueType();

    public abstract void setIssuLevel();

    public abstract void setIssuePath();

    public abstract void setIssueDescription();

    public abstract void setDealFlag();

    public DataParseIssueBean getDataParseIssueBean() {
        return this.dataParseIssueBean;
    }
}
