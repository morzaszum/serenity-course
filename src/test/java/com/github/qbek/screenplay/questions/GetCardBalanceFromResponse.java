package com.github.qbek.screenplay.questions;

import abilities.Card;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.thucydides.core.steps.StepEventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class GetCardBalanceFromResponse implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {


        String response = actor.asksFor(new LastResponse()).getBody().asString();
        // Sposob 1


        try {
            JSONObject obj = new JSONObject(response);
            return obj.getInt("balance");
        } catch (JSONException e) {
            StepEventBus.getEventBus().testFailed(e);
        }


//        2
//        ObjectMapper mapper = new ObjectMapper();
//        Card card = null;
//        try {
//            card = mapper.readValue(response, Card.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return card.getBalance();
//
//        3
//        Card card = actor.asksFor(new LastResponse()).getBody().as(Card.class);
//        return card.getBalance();
return null;
    }
}
