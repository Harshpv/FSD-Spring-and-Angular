package com.userservice.config;

import com.userservice.rabbitmq.model.UserCredentials;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private AmqpTemplate template;
    private TopicExchange exchange;

    public Producer(AmqpTemplate template, TopicExchange exchange) {
        super();
        this.template = template;
        this.exchange = exchange;
    }

    public void sendMessageToRabbitMq(UserCredentials userCredentials) {
        template.convertAndSend(exchange.getName(),"message_routingKey", userCredentials);
    }
}
