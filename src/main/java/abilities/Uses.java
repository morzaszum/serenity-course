package abilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class Uses {

    private static Faker faker = new Faker();
    private static MockServerClient client = new MockServerClient("localhost", 8080);

    public static UseCards useDebitCard() throws JsonProcessingException {
        Card card = new Card(
                faker.numerify("11034########"),
                faker.business().creditCardExpiry(),
                faker.number().numberBetween(10, 100)
        );
        injectTestCard(card);
        UseCards useCards = new UseCards(card);
        return useCards;
    }

    public static UseCards useCreditCard() throws JsonProcessingException {
        Card card = new Card(
                faker.numerify("22034########"),
                faker.business().creditCardExpiry(),
                faker.number().numberBetween(10, 100)
        );
        injectTestCard(card);
        UseCards useCards = new UseCards(card);
        return useCards;
    }

    public static UseAccount useAccount() throws JsonProcessingException {
        Credentials creds = new Credentials(
                faker.dragonBall().character(),
                faker.witcher().monster()
        );
        injectLogin(creds);
        UseAccount useAccount = new UseAccount(creds);
        return useAccount;
    }

    private static void injectTestCard(Card card) throws JsonProcessingException {
        String path = "/card" + card.getPam();
        ObjectMapper mapper = new ObjectMapper();
        String responseBody = mapper.writeValueAsString(card);
        System.out.println("CARD JSON "+responseBody);
        client.when(
                HttpRequest.request().withMethod("GET").withPath(path)
        ).respond(
                HttpResponse.response().withStatusCode(200).withBody(responseBody)
        );

    }

    private static void injectLogin(Credentials creds) throws JsonProcessingException {
        String path = "/login";
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(creds);
        client.when(
                HttpRequest.request().withMethod("POST").withBody(requestBody).withPath(path)
        ).respond(
                HttpResponse.response().withStatusCode(200)
        );

    }

}
