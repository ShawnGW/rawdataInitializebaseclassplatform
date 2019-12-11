package com.vtest.it.ftplatform.dao.mes;

import com.alibaba.fastjson.JSON;
import com.vtest.it.common.pojo.RawDataFtBean;
import com.vtest.it.ftplatform.service.MesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MesDaoTest {

    @Autowired
    private MesService mesDao;

    @Test
    public void test(){
        RawDataFtBean rawDataFtBean=mesDao.getLotConfig("AOSMD47F04.02","FT1");
        System.err.println(JSON.toJSONString(rawDataFtBean));
    }
}