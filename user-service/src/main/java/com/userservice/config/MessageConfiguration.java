//<<<<<<<< HEAD:user-service/src/main/java/com/userservice/config/MessageConfiguration.java
//package com.userservice.config;
//========
//package com.niit.userservice.model;
//>>>>>>>> 63edf689972ce1eb50bf84b490f62882ed9e74ae:user-service/src/main/java/com/niit/userservice/model/MQConfig.java
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class MessageConfiguration {
//
//    public static final String QUEUE = "user_credentials";
//    public static final String EXCHANGE = "credentials_exchange";
//    public static final String ROUTING_KEY = "message_routingKey";
//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE);
//    }
//
//    @Bean
//    public TopicExchange exchange() {
//        return new TopicExchange(EXCHANGE);
//    }
//    @Bean
//    public Binding binding (Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
//    }
//    @Bean
//    public MessageConverter messageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//    @Bean
//    public AmqpTemplate template(ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(messageConverter());
//        return template;
//    }
//}
