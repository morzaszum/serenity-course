package utils;

import abilities.Card;
import abilities.Credentials;
import com.fasterxml.jackson.core.JsonProcessingException;
import facts.CardType;

public interface SystemSetup {

    void setupCredentials(Credentials credentials) throws JsonProcessingException;
    void setupCard(Card card) throws JsonProcessingException;

}
