package com.nonder.chatbot;

import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.ai.model.function.FunctionCallbackWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {

    @Bean
    public FunctionCallback eventFunctionCall() {
        return FunctionCallbackWrapper.builder(new MockEventService())
                .withName("UpcomingEvents")
                .withDescription("List upcoming party, sport, and tech talk events at adesso.")
                .build();
    }

    @Bean
    public FunctionCallback eventRegisteryFunctionCall() {
        return FunctionCallbackWrapper.builder(new MockEventRegisterService())
                .withName("EventRegister")
                .withDescription("Register for events at adesso.")
                .build();
    }
}
