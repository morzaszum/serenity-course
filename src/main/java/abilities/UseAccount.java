package abilities;

import net.serenitybdd.screenplay.Ability;

public class UseAccount implements Ability {

    private Credentials credentials;

    UseAccount(Credentials credentials){
        this.credentials = credentials;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    @Override
    public String toString() {
        return "has credentials, login "+getCredentials().getLogin()+ " and password "+getCredentials().getPassword();
    }
}
