package com.vtest.it.ftplatform.dao.vtftmt;

import com.vtest.it.ftplatform.pojo.vtftmt.DataParseIssueBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface VtftmtDao {
    public void logError(DataParseIssueBean dataParseIssueBean);
}
