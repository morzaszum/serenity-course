package com.github.qbek.screenplay;

import abilities.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

public class CardBalanceSteps {

    @Before
    public void setup() {
        OnStage.setTheStage(new Cast());
    }

    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        Actor user = OnStage.theActorCalled(name).describedAs("is a card user with active account");
        user.can(Uses.useCreditCard());
        user.can(Uses.useAccount());
    }

    @And("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String name) {
        Actor user = OnStage.theActorCalled(name);

        Credentials creds = user.usingAbilityTo(UseAccount.class).getCredentials();

        System.out.println(creds.getLogin() + " " + creds.getPassword());
    }

    @Then("^correct balance is presented$")
    public void correctBalanceIsPresented() {
        Actor user = OnStage.theActorInTheSpotlight();

    }

    @When("^(\\w+) checks his card balance$")
    public void carlChecksHisCardBalance(String name) {
        Actor user = OnStage.theActorCalled(name);
        Card card = user.usingAbilityTo(UseCards.class).getCard();
        System.out.println(card.getPam());
    }
}
