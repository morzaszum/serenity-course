package com.github.qbek.screenplay;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.qbek.screenplay.Cast.SuperHeroClass;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.github.qbek.screenplay.Tasks.Tasks.*;
import static facts.Facts.accountWithCreditCard;
import static facts.Facts.accountWithDebitCard;

public class CardBalanceSteps {

    @Before
    public void setup() {
        OnStage.setTheStage(new SuperHeroClass());
    }

    @Given("^(\\w+) is a debit card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        Actor user = OnStage.theActorCalled(name).describedAs("is a debit card user with active account");
        user.has(accountWithDebitCard());
    }

    @Given("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String name) throws JsonProcessingException {
        Actor user = OnStage.theActorCalled(name);
        user.attemptsTo(userLogsIntoAccount());
    }


    @When("^(\\w+) checks his card balance$")
    public void checkHisDebitCardBalance(String name) {
        Actor user = OnStage.theActorCalled(name);
        user.attemptsTo(checkHisCardBalance());
    }


    @Given("^(\\w+) is a credit card user with active account$")
    public void carlIsACreditCardUserWithActiveAccount(String name) throws Throwable {
        Actor user = OnStage.theActorCalled(name).describedAs("is a credit card user with active account");
        user.has(accountWithCreditCard());
    }
}
