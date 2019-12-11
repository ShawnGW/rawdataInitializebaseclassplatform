package com.vtest.it.ftplatform.service.impl;

import com.vtest.it.common.pojo.RawDataFtBean;
import com.vtest.it.ftplatform.dao.mes.MesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "mesDataSourceTransactionManager",propagation = Propagation.REQUIRED,readOnly = true,isolation = Isolation.READ_UNCOMMITTED)
public class MesServiceImpl implements com.vtest.it.ftplatform.service.MesService {
    private static final Logger logger= LoggerFactory.getLogger(MesServiceImpl.class);
    @Autowired
    private MesDao mesDao;

    @Override
    @Cacheable(cacheManager = "redisCacheManager",cacheNames = "ftCache",key = "#root.methodName+'&'+#lotId+'&'+#FtStep",unless = "#result==null")
    public RawDataFtBean getLotConfig(String lotId, String FtStep) {
        return mesDao.getLotConfig(lotId,FtStep);
    }
}
