package com.vtest.it.fttesterdataloginitialtext;

import com.vtest.it.fttesterdataloginitialtext.pojo.StdfInformationBean;
import com.vtest.it.fttesterdataloginitialtext.service.stdfNameParse.StdfParser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
class FtTesterDatalogInitialTextApplicationTests {

    @Autowired
    private StdfParser stdfParser;
    @Test
    void contextLoads() {
         StdfInformationBean  stdfInformationBean=stdfParser.parse(new File("E:\\bk\\DPB198\\VTEST_FT_AOS_SCT401B_K3NRH-KUB0111_AOSED48F15.08_TTN-02_HHT-20_LB-SCT401B-FT1_FT1_RP0_1072_20191215_210924.txt"));
        System.err.println(stdfInformationBean);
    }

}
