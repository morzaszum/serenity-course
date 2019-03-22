package utils;

import abilities.Card;
import abilities.Credentials;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface SystemSetup {

    void setupCredentials(Credentials credentials) throws JsonProcessingException;
    void setupCreditCard(Card card) throws JsonProcessingException;
}
