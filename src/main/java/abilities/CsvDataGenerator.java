package abilities;

public class CsvDataGenerator implements TestDataGenerator {

    @Override
    public UseCards createDebitCard() {
        System.out.println("CSV DEBIT CARD");
        return null;
    }

    @Override
    public UseCards createCreditCard() {
        System.out.println("CSV CREDIT CARD");
        return null;
    }

    @Override
    public UseAccount createAccount() {
        System.out.println("Account from CSV");
        return null;
    }


}
