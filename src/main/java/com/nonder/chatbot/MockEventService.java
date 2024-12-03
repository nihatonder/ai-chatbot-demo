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
            new Event("Happy Hour", LocalDate.now().plusDays(5)),
            new Event("New Year Party", LocalDate.now().withDayOfYear(360))
    );

    List<Event> sportList = List.of(
            new Event("Scuba Diving", LocalDate.now().withDayOfYear(200)),
            new Event("Windsurfing", LocalDate.now().withDayOfYear(250)),
            new Event("Running", LocalDate.now().plusDays(70))
    );

    List<Event> techTalkList = List.of(
            new Event("Code review", LocalDate.now().plusDays(5)),
            new Event("IoT solutions", LocalDate.now().plusDays(35)),
            new Event("GraalVM with AWS Lambda", LocalDate.now().plusDays(65))
    );

    public Response apply(Request request) {
        return switch (request.eventType) {
            case PARTY -> new Response(partyList);
            case SPORT -> new Response(sportList);
            case TECH_TALK -> new Response(techTalkList);
        };
    }
}