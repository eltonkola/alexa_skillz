package com.eltonkola.alexa.birthdayguru.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.eltonkola.alexa.birthdayguru.ConstUtils;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class HelpIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "By asking me i am born in your birthday, i will tell you what day it was!";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(ConstUtils.CARD_NAME, speechText)
                .withReprompt(speechText)
                .build();
    }
}
