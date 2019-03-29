package facts;

import net.serenitybdd.screenplay.facts.Fact;

import static facts.CardType.CREDIT;
import static facts.CardType.NONE;

public class Facts {


    public static Fact accountWithDebitCard() throws Exception {
        return new AccountWithOptionalCard(CardType.DEBIT);
    }

    public static Fact accountWithCreditCard() throws Exception {
        return new AccountWithOptionalCard(CREDIT);
    }

    public static Fact account() throws Exception {
        return new AccountWithOptionalCard(NONE);
    }
}
