package com.vtest.it.ftplatform.configuration;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitmqConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.rabbitmq")
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory=new CachingConnectionFactory();
        return cachingConnectionFactory;
    }
    @Bean
    @Primary
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setExchange("rawdata.init.exchange");
        rabbitTemplate.setRoutingKey("rawdata.information.vtest");
        return rabbitTemplate;
    }
    @Bean
    @Primary
    public RabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory,RabbitListenerErrorHandler rabbitListenerErrorHandler){
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory=new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setMessageConverter(new Jackson2JsonMessageConverter());
        simpleRabbitListenerContainerFactory.setPrefetchCount(2);
        simpleRabbitListenerContainerFactory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return simpleRabbitListenerContainerFactory;
    }
    @Bean
    public RabbitListenerErrorHandler rabbitListenerErrorHandler(){
        return new RabbitListenerErrorHandler() {
            @Override
            public Object handleError(Message message, org.springframework.messaging.Message<?> message1, ListenerExecutionFailedException e) throws Exception {
                return null;
            }
        };
    }
}
