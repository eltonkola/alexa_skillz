package com.eltonkola.alexa.birthdayguru;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.eltonkola.alexa.birthdayguru.handlers.CancelandStopIntentHandler;
import com.eltonkola.alexa.birthdayguru.myhandlers.BirthdayIntentHandler;
import com.eltonkola.alexa.birthdayguru.handlers.HelpIntentHandler;
import com.eltonkola.alexa.birthdayguru.handlers.SessionEndedRequestHandler;
import com.eltonkola.alexa.birthdayguru.handlers.LaunchRequestHandler;
import com.eltonkola.alexa.birthdayguru.handlers.FallbackIntentHandler;

public class BirthdayStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new BirthdayIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler())
                .build();
    }

    public BirthdayStreamHandler() {
        super(getSkill());
    }

}
