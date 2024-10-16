package com.nonder.chatbot;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class AIController {

    private final OpenAiChatModel openAiChatModel;

    AIController(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @GetMapping("/ai")
    Map<String, String> completion(String message) {

        var response = openAiChatModel.call(new Prompt(new UserMessage(message),
                OpenAiChatOptions.builder()
                        .withFunction("UpcomingEvents")
                        .withFunction("EventRegister")
                        .build()
        ));

        return Map.of(
                "completion", response.getResult().getOutput().getContent());
    }
}
