package com.vtest.it.ftplatform.advisor;

import com.rabbitmq.client.Channel;
import com.vtest.it.common.pojo.FtStdfInitialBean;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Aspect
public class RabbitInformationConfirm {

    private static final Logger logger = LoggerFactory.getLogger(RabbitInformationConfirm.class);

    @AfterThrowing(pointcut = "execution(public * com.vtest.it.ftplatform.service.impl.RabbitServiceImpl.getInitialBean(..))&&args(bean,deliveryTag,channel)", throwing = "exception")
    public void informationInitialDeal(FtStdfInitialBean bean,long deliveryTag, Channel channel, Exception exception) {
        try {
            channel.basicNack(deliveryTag, false, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
