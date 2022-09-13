package com.userservice.model;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public Queue queue() {
        return new Queue("user_credentials");
    }
}
