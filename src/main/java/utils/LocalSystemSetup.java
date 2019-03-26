package utils;

import abilities.Card;
import abilities.Credentials;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import facts.CardType;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class LocalSystemSetup implements SystemSetup {
    private static MockServerClient client = new MockServerClient("localhost", 8080);

    @Override
    public void setupCredentials(Credentials credentials) throws JsonProcessingException {

        String path = "/login";
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(credentials);
        client.when(
                HttpRequest.request().withMethod("POST").withBody(requestBody).withPath(path)
        ).respond(
                HttpResponse.response().withStatusCode(200)
        );

        System.out.println("System setup Test data in mock server");
    }

    @Override
    public void setupCard(Card card) throws JsonProcessingException {
        String path = "/" + card.getType().toString().toLowerCase()+"/"+ card.getPan();
        ObjectMapper mapper = new ObjectMapper();
        String responseBody = mapper.writeValueAsString(card);
        System.out.println("CARD JSON " + responseBody);
        client.when(
                HttpRequest.request().withMethod("GET").withPath(path)
        ).respond(
                HttpResponse.response()
                        .withStatusCode(200)
                        .withBody(responseBody)
                        .withHeader("Content-Type", "application/json")
        );
        System.out.println("SystemSetupTest data in mock server");
    }
}
