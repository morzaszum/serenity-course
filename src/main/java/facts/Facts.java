package facts;

import net.serenitybdd.screenplay.facts.Fact;

import static facts.CardType.CREDIT;

public class Facts {


    public static Fact accountWithDebitCard() throws Exception {
        return new AccountWithCard(CardType.DEBIT);
    }

    public static Fact accountWithCreditCard() throws Exception {
        return new AccountWithCard(CREDIT);
    }
}
