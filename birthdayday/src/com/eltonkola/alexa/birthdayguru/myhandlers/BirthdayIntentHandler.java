package com.eltonkola.alexa.birthdayguru.myhandlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.eltonkola.alexa.birthdayguru.ConstUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class BirthdayIntentHandler implements RequestHandler {

    private static final Logger log = LoggerFactory.getLogger(BirthdayIntentHandler.class);

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("YourBirthdayDate"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        String speechText;

        try{
            IntentRequest intentRequest = (IntentRequest) input.getRequestEnvelope().getRequest();

            Slot datex = intentRequest.getIntent().getSlots().get("birthday");


            Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
            log.info("sessionAttributes: " + sessionAttributes.size());

            String date  = datex.getValue();
            log.info("date: " + date);


            SimpleDateFormat parser =new SimpleDateFormat("yyyy-MM-dd");

            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            Date theDate = parser.parse(date);


            log.info("theDate: " + theDate);


            String dayOfTheWeek = sdf.format(theDate);

            log.info("dayOfTheWeek: " + dayOfTheWeek);

            speechText = "You are born on " + dayOfTheWeek;

            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(ConstUtils.CARD_NAME, speechText)
                    .build();

        }catch (Exception e){

            speechText = "Cant understand your birthday!";



        }

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(ConstUtils.CARD_NAME, speechText)
                .build();


    }


}
