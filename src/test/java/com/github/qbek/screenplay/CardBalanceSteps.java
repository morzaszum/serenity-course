package com.github.qbek.screenplay;

import abilities.Card;
import abilities.Credentials;
import abilities.UseAccount;
import abilities.UseCards;
import com.github.javafaker.Faker;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import javax.jws.soap.SOAPBinding;

public class CardBalanceSteps {

    @Before
    public void setup() {
        OnStage.setTheStage(new Cast());
    }

    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        Faker faker = new Faker();

        Actor user = OnStage.theActorCalled(name).describedAs("is a card user with active account");
        Card card = new Card(
                faker.numerify("11034## ### ###"),
                faker.business().creditCardExpiry(),
                faker.number().numberBetween(10, 100)
        );

        UseCards useCards = new UseCards(card);

        Credentials creds = new Credentials(
                faker.dragonBall().character(),
                faker.witcher().monster()
        );

        UseAccount useAccount = new UseAccount(creds);

        user.can(useCards);
        user.can(useAccount);

    }

    @And("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String name) {
        Actor user = OnStage.theActorCalled(name);

        Credentials creds = user.usingAbilityTo(UseAccount.class).getCredentials();

        System.out.println(creds.getLogin()+" "+creds.getPassword());
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
