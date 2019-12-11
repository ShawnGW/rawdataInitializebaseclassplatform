package com.vtest.it.tskplatformgeneraterawdata.service.impl;

import com.vtest.it.common.pojo.RawDataFtBean;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private int i=0;
    @Scheduled(fixedDelay = 100)
    public void sender() {
        RawDataFtBean rawDataFtBean=new RawDataFtBean();
        rawDataFtBean.setLotId("test"+(++i));
        rabbitTemplate.convertAndSend(rawDataFtBean);
    }
}
