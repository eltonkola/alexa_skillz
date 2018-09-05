package com.eltonkola.alexa.birthdayguru.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.eltonkola.alexa.birthdayguru.ConstUtils;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Welcome to the birthday guru, you can ask me what day your birthday was";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(ConstUtils.CARD_NAME, speechText)
                .withReprompt(speechText)
                .build();
    }

}
