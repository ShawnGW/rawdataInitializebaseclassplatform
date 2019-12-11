package com.vtest.it.ftplatform.dao.mes;

import com.vtest.it.common.pojo.RawDataFtBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MesDao {
    public RawDataFtBean getLotConfig(@Param("lotId")String lotId, @Param("ftStep")String FtStep);
}
