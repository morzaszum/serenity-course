package abilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class RandomTestDataGenerator implements TestDataGenerator{

    private static Faker faker = new Faker();

    @Override
    public  UseCards createDebitCard() {
        Card card = new Card(
                faker.numerify("11022########"),
                faker.business().creditCardExpiry(),
                faker.number().numberBetween(10, 100)
        );
        UseCards useCards = new UseCards(card);
        System.out.println("Random debit card");
        return useCards;
    }
    @Override
    public  UseCards createCreditCard() {
        Card card = new Card(
                faker.numerify("33022########"),
                faker.business().creditCardExpiry(),
                faker.number().numberBetween(10, 100)
        );
        UseCards useCards = new UseCards(card);
        System.out.println("Random credit card");
        return useCards;
    }

    public UseAccount createAccount()  {
        Credentials creds = new Credentials(
                faker.dragonBall().character(),
                faker.witcher().monster()
        );
        UseAccount useAccount = new UseAccount(creds);
        System.out.println("Random account card");
        return useAccount;
    }



}
