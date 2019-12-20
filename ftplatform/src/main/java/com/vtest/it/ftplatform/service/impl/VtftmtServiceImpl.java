package com.vtest.it.ftplatform.service.impl;

import com.vtest.it.ftplatform.dao.vtftmt.VtftmtDao;
import com.vtest.it.ftplatform.pojo.vtftmt.DataParseIssueBean;
import com.vtest.it.ftplatform.service.VtftmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "FtDataSourceTransactionManager",propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
public class VtftmtServiceImpl implements VtftmtService {

    @Autowired
    private VtftmtDao  vtftmtService;

    @Override
    public void logError(DataParseIssueBean dataParseIssueBean) {
        vtftmtService.logError(dataParseIssueBean);
    }
}
