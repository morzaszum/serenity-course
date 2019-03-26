package utils;

import abilities.Card;
import abilities.Credentials;
import com.fasterxml.jackson.core.JsonProcessingException;
import facts.CardType;

public class UatSetup implements SystemSetup {
    @Override
    public void setupCredentials(Credentials credentials) {
        System.out.println("Login data on UAT user");
    }

    @Override
    public void setupCard(Card card) throws JsonProcessingException {
        System.out.println("Card data on UAT");

    }

}
