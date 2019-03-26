package com.github.qbek.screenplay.Tasks;

import abilities.Credentials;
import abilities.UseAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.StepEventBus;

public class LogsInToAccount implements Task {

    @Override
    @Step("{0} logs into his account")
    public <T extends Actor> void performAs(T actor) {

        try {
            Credentials creds = actor.usingAbilityTo(UseAccount.class).getCredentials();
            ObjectMapper mapper = new ObjectMapper();
            String credentials = mapper.writeValueAsString(creds);
            actor.attemptsTo(Post.to("/login").with(req -> req.body(credentials)));
        } catch (JsonProcessingException e) {
            StepEventBus.getEventBus().testFailed(e);
        }

    }
}
