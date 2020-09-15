package com.vtest.it.ftstdfparse.service.message;

import com.vtest.it.common.pojo.FtStdfInitialBean;
import com.vtest.it.common.pojo.StdfInformationBean;
import com.vtest.it.common.stdfNameParse.impl.J750StdfParserImpl;
import com.vtest.it.ftstdfparse.service.stdfparse.FtStdfParse;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author shawn.sun
 * @date 2020-9-15 11:55:20
 */
@Service
public class MessageSender {

    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FtStdfParse parse;
    @Value("${system.file.path}")
    private String path;

    @Scheduled(fixedDelay = 2000)
    public void sender() {
        J750StdfParserImpl j750StdfParser=new J750StdfParserImpl();
        List<File> list=new LinkedList<>();
        getFileNeedDeal(new File(path),list);
        for (File file : list) {
            if (checkLastModifyTime(file,120)){
                try {
                    StdfInformationBean bean = j750StdfParser.parse(file);
                    FtStdfInitialBean ftStdfInitialBean = parse.parse(file);
                    ftStdfInitialBean.setFtStep(bean.getFtStep());
                    ftStdfInitialBean.setRpStep(bean.getRpStep());
                    ftStdfInitialBean.setVtLot(bean.getvLot());
                    ftStdfInitialBean.setOperator(bean.getOperator());
                    ftStdfInitialBean.setLotId(bean.getLot());
                    if (null == ftStdfInitialBean.getTestEndTime()) {
                        ftStdfInitialBean.setTestEndTime(ftStdfInitialBean.getTestStartTime());
                    }
                    rabbitTemplate.convertAndSend("rawdata.init.exchange", "rawdata.information.vtest", ftStdfInitialBean);
                    logger.info(ftStdfInitialBean.getLotId());
                    logger.info(ftStdfInitialBean.getFtStep());
                    logger.info(file.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        FileUtils.forceDelete(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean checkLastModifyTime(File file, int seconds) {
        long currentTime = System.currentTimeMillis();
        long fileLastModifyTime = file.lastModified();
        if (((currentTime - fileLastModifyTime) / 1000) > seconds) {
            return true;
        }
        return false;

    }

    public void  getFileNeedDeal(File file,List<File> list){
        if (file.isFile()) {
            list.add(file);
        } else if (Objects.requireNonNull(file.listFiles()).length == 0) {
            try {
                if (!file.getName().equals("stdfTxt")) {
                    FileUtils.forceDelete(file);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            File[] files = file.listFiles();
            for (int i = 0; i < Objects.requireNonNull(files).length; i++) {
                getFileNeedDeal(files[i], list);
            }
        }

    }
}
