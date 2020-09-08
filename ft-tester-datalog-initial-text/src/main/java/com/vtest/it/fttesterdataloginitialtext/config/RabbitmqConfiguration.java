package com.vtest.it.fttesterdataloginitialtext.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author shawn.sun
 * @date 2020/08/12  15:45
 */
@Configuration
public class RabbitmqConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.rabbitmq")
    @Primary
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setPublisherReturns(true);
        return cachingConnectionFactory;
    }

    @Bean
    @Primary
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, RabbitTemplate.ReturnCallback returnCallback, RetryTemplate retryTemplate) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setExchange("uid");
        rabbitTemplate.setRoutingKey("uid.log.path.wait");
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.setRetryTemplate(retryTemplate);
        return rabbitTemplate;
    }

    @Bean
    @Primary
    public RabbitTemplate.ReturnCallback returnCallback() {
        //Message message, int replyCode, String replyText, String exchange, String routingKey
        return (message, replyCode, replyText, exchange, routingKey) -> {
            System.out.println(message);
        };
    }

    @Bean
    @Primary
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy(Integer.MAX_VALUE);
        retryTemplate.setRetryPolicy(simpleRetryPolicy);
        return retryTemplate;
    }
}
