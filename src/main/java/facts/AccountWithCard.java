package facts;

import abilities.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import utils.LocalSystemSetup;
import utils.SystemSetup;
import utils.UatSetup;

import static abilities.RandomTestDataGenerator.*;

public class AccountWithCard implements Fact {
    private static MockServerClient client = new MockServerClient("localhost", 8080);
    private CardType cardType;
    private TestDataGenerator data;
    private SystemSetup sysSetup;

    public AccountWithCard(CardType cardType) throws Exception {
        this.cardType = cardType;
        data = getTestDataGenerator();
        sysSetup = getSystemSetup();
    }

    private TestDataGenerator getTestDataGenerator() throws Exception {
        switch (System.getProperty("env")) {
            case "local":
                return new RandomTestDataGenerator();
            case "uat":
                return new CsvDataGenerator();
        }
        throw new Exception("nie wspierane srodowisko");

    }

    private SystemSetup getSystemSetup() throws Exception {
        switch (System.getProperty("env")) {
            case "local":
                return new LocalSystemSetup();
            case "uat":
                return new UatSetup();
        }
        throw new Exception("nie wspierane srodowisko");

    }


    @Override
    public void setup(Actor actor) {
        System.out.println("Testy odpalimy na " + System.getProperty("env"));
        try {
            actor.can(useCard());
            actor.can(useAccount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Ability useCard() throws Exception {
        UseCards useCard;

        switch (cardType) {
            case DEBIT:
                useCard = data.createDebitCard();
                break;
            case CREDIT:
                useCard = data.createCreditCard();
                break;

            default:
                throw new Exception("Unknown card type");
        }
        return useCard;
    }

    private Ability useAccount() throws JsonProcessingException {
        UseAccount useAccount = data.createAccount();
        sysSetup.setupCredentials(useAccount.getCredentials());
        return useAccount;
    }

    @Override
    public String toString() {
        return "Account with " + cardType + " card";
    }




}
