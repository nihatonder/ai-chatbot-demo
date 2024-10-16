package com.nonder.chatbot;

import java.time.LocalDate;
import java.util.function.Function;

import static java.time.format.DateTimeFormatter.ofPattern;

public class MockEventRegisterService implements Function<MockEventRegisterService.Request, MockEventRegisterService.Response> {
    public record Request(String event, LocalDate date) {
    }

    public record Response(boolean result) {
    }

    public Response apply(Request request) {
        System.out.printf("Registered for the event %s on %s%n",
                request.event,
                request.date != null ? request.date.format(ofPattern("dd-MM-yyyy")) : "no date specified"
        );
        return new Response(true);
    }
}