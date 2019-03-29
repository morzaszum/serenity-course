package com.github.qbek.screenplay.asserts;

import abilities.Card;
import abilities.UseCards;
import com.github.qbek.screenplay.questions.GetCardBalanceFromResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.QuestionConsequence;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.rest.questions.TheResponseStatusCode;
import org.hamcrest.Matchers;

public class Checks  {

    public static Consequence shouldNotLoggedIn() {
        return  checkResponseStatusCode(404);
    }

    public static Consequence beLoggedIn() {
        return checkResponseStatusCode(200);
    }

    private static Consequence checkResponseStatusCode(int code){
        return new QuestionConsequence("response code should be",
                new TheResponseStatusCode(),
                Matchers.equalTo(code));
    }

    public static Consequence seeCorrectBalance() {
        Actor actor = OnStage.theActorInTheSpotlight();
        Card card = actor.usingAbilityTo(UseCards.class).getCard();
        return new QuestionConsequence(
                "balance should be",
                new GetCardBalanceFromResponse(),
                Matchers.equalTo(((Card) card).getBalance()+100)
                );
    }
}
