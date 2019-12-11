package com.vtest.it.ftplatform.service;

import com.vtest.it.common.pojo.RawDataFtBean;

public interface MesService {
    public RawDataFtBean getLotConfig(String lotId, String FtStep);
}
