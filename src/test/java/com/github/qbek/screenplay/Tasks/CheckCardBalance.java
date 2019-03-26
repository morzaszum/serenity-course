package com.github.qbek.screenplay.Tasks;

import abilities.Card;
import abilities.UseCards;
import facts.CardType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static facts.CardType.DEBIT;

public class CheckCardBalance implements Task {


    @Override
    @Step("{0} check his card balance")
    public <T extends Actor> void performAs(T actor) {
        Card card = actor.usingAbilityTo(UseCards.class).getCard();
        SerenityRest.when().get(String.format("/%s/%s",card.getType().toString().toLowerCase(),card.getPan()));

    }


}
