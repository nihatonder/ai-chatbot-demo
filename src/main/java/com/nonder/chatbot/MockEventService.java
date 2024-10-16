package com.nonder.chatbot;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public class MockEventService implements Function<MockEventService.Request, MockEventService.Response> {

    enum EventType {PARTY, SPORT, TECH_TALK}

    public record Request(EventType eventType) {
    }

    public record Event(String event, LocalDate date) {
    }

    public record Response(List<Event> eventList) {
    }

    List<Event> partyList = List.of(
            new Event("Happy Hour", LocalDate.of(2024, 10, 18)),
            new Event("New Year Party", LocalDate.of(2024, 12, 21))
    );

    List<Event> sportList = List.of(
            new Event("Scuba Diving", LocalDate.of(2024, 10, 20)),
            new Event("Windsurfing", LocalDate.of(2024, 10, 25)),
            new Event("Running", LocalDate.of(2024, 11, 01))
    );

    List<Event> techTalkList = List.of(
            new Event("Code review", LocalDate.of(2024, 11, 21)),
            new Event("IoT solutions", LocalDate.of(2024, 12, 19)),
            new Event("GraalVM with AWS Lambda", LocalDate.of(2025, 1, 16))
    );

    public Response apply(Request request) {
        return switch (request.eventType) {
            case PARTY -> new Response(partyList);
            case SPORT -> new Response(sportList);
            case TECH_TALK -> new Response(techTalkList);
        };
    }
}