package com.vtest.it.ftstdfparse.service.message;

import com.vtest.it.common.pojo.FtStdfInitialBean;
import com.vtest.it.ftstdfparse.service.stdfparse.FtStdfParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class MessageSender {

    private static final Logger logger= LoggerFactory.getLogger(MessageSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FtStdfParse parse;
    @Value("${system.file.path}")
    private String path;

    @Scheduled(fixedDelay = 2000)
    public void sender() throws IOException {
        File[] files=new File(path).listFiles();
        for (File file : files) {
            FtStdfInitialBean ftStdfInitialBean=parse.parse(file);
            rabbitTemplate.convertAndSend("rawdata.init.exchange","rawdata.information.vtest",ftStdfInitialBean);
            logger.error("send success!");
        }
    }
}
