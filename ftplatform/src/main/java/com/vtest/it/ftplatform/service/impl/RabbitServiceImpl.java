package com.vtest.it.ftplatform.service.impl;

import com.rabbitmq.client.Channel;
import com.vtest.it.common.pojo.FtStdfInitialBean;
import com.vtest.it.common.pojo.RawDataFtBean;
import com.vtest.it.ftplatform.service.MesService;
import com.vtest.it.ftplatform.service.rawdataTools.RawDataDeal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;

@Service
public class RabbitServiceImpl {
    @Autowired
    private MesService mesService;
    @Autowired
    private RawDataDeal rawdataDeal;

    @RabbitListener(queues = "rawdata.init.queue")
    public void getInitialBean(@Payload FtStdfInitialBean bean, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException, ParseException {
        RawDataFtBean rawDataFtBean = mesService.getLotConfig(bean.getVtLot(), bean.getFtStep());
        rawdataDeal.deal(bean, rawDataFtBean);
        channel.basicAck(deliveryTag, false);
    }
}
