package com.github.qbek.screenplay.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.questions.TheResponseStatusCode;
import net.thucydides.core.annotations.Step;

import static com.github.qbek.screenplay.Tasks.Tasks.logsIntoAccount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserSuccessfullyLogsIntoAccount implements Task {

    @Override
    @Step("{0} Successfully logs into account")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Task.where("",logsIntoAccount()).withNoReporting());
        int responseStatusCode = actor.asksFor(new TheResponseStatusCode());
        System.out.println("Response status code " + responseStatusCode);
        assertThat("User is not logged in", responseStatusCode, equalTo(200));

    }
}
