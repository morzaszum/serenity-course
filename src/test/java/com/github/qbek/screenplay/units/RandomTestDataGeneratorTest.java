package com.github.qbek.screenplay.units;

import abilities.Card;
import abilities.RandomTestDataGenerator;
import abilities.TestDataGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class RandomTestDataGeneratorTest {
    TestDataGenerator data = new RandomTestDataGenerator();

    @Test
    public void canGenerateCreditCard()  {
        Card card = data.createCreditCard().getCard();
        assertThat("Karta kredutowa bin: 33022", card.getPan(), Matchers.containsString("33022"));
    }

    public void canGenerateDebitCard() throws JsonProcessingException {
        Card card = data.createDebitCard().getCard();
        assertThat("Karta kredutowa bin: 110022", card.getPan(), Matchers.containsString("110022"));
    }
}
