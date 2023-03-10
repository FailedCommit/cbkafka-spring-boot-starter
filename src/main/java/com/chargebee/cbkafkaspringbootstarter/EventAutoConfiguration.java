package com.chargebee.cbkafkaspringbootstarter;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */

@Configuration
@ConditionalOnProperty(value = "eventstarter.enabled", havingValue = "true")
@ConditionalOnClass(name = "com.chargebee.cbkafkaspringbootstarter.MyDummyLibrary")
@EnableConfigurationProperties(EventListenerProperties.class)
class EventAutoConfiguration {

    @Bean
    EventPublisher eventPublisher(List<EventListener> listeners){
        return new EventPublisher(listeners);
    }

    @Bean
    Event event(String type, String payload) {
        return new Event(type, payload);
    }
}
