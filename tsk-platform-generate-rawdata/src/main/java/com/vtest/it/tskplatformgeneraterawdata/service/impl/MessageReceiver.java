package com.vtest.it.tskplatformgeneraterawdata.service.impl;

import com.rabbitmq.client.Channel;
import com.vtest.it.common.pojo.RawDataFtBean;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class MessageReceiver {
    @RabbitListener(queues = "rawdata.init.queue")
    public void receive(RawDataFtBean rawDataFtBean, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println(rawDataFtBean.getLotId());
        System.err.println(deliveryTag);
        try {
//            channel.basicNack(deliveryTag, false, false);
            channel.basicReject(deliveryTag,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
