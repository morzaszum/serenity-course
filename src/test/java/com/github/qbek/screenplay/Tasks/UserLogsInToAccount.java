package com.github.qbek.screenplay.Tasks;

import abilities.Credentials;
import abilities.UseAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.TheResponseStatusCode;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.StepEventBus;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserLogsInToAccount implements Task {

    @Override
    @Step("{0} tries logs into his account")
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
