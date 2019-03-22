package abilities;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface TestDataGenerator {

    UseCards createDebitCard();
    UseCards createCreditCard();
    UseAccount createAccount();
}
