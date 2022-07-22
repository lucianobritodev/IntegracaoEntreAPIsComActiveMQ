package com.lucianobrito.pruductsproducer.configurations;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JmsConfig {

    @Value( "${spring.activemq.broker-url}" )
    private String brokerUrl;

    @Value( "${spring.activemq.user}" )
    private String user;

    @Value( "${spring.activemq.password}" )
    private String password;

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        if (user.equals("")) {
            return new ActiveMQConnectionFactory(brokerUrl);
        }
        return new ActiveMQConnectionFactory(user, password, brokerUrl);
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(connectionFactory());
    }
}