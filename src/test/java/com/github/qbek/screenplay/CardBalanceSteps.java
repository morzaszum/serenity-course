package com.github.qbek.screenplay;

import abilities.UseAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.qbek.screenplay.Cast.SuperHeroClass;
import com.github.qbek.screenplay.Tasks.Tasks;
import com.github.qbek.screenplay.asserts.Checks;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.QuestionConsequence;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.TheResponseStatusCode;
import org.hamcrest.Matchers;

import static com.github.qbek.screenplay.Tasks.Tasks.*;
import static com.github.qbek.screenplay.asserts.Checks.seeCorrectBalance;
import static com.github.qbek.screenplay.asserts.Checks.shouldNotLoggedIn;
import static facts.Facts.*;

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
        user.wasAbleTo(succesfullyLoggsIntoAccount());
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

    @Given("^(\\w+) is a user with active account$")
    public void helmutIsAUserWithActiveAccount(String name) throws Exception {
        Actor user = OnStage.theActorCalled(name);
        user.has(account());

    }

    @When("^(\\w+) tries to login with incorrect credentials$")
    public void heTriesToLoginWithIncorrectCredentials(String name) {
        Actor user = OnStage.theActorCalled(name);
        user.attemptsTo(changeHisPassword());
        user.attemptsTo(logsIntoAccount());
    }

    @Then("^correct balance is presented$")
    public void correctBalanceIsPresented() {
        Actor user = OnStage.theActorInTheSpotlight();
        user.should(seeCorrectBalance());
    }

    @Then("^(\\w+) is not logged in$")
    public void heIsNotLoggedIn(String name) {
        Actor user = OnStage.theActorCalled(name);
        user.should(shouldNotLoggedIn());
    }
}
