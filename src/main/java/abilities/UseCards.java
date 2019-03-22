package abilities;

import net.serenitybdd.screenplay.Ability;


public class UseCards implements Ability {

    Card card;

    public UseCards(Card toUse) {
        this.card = toUse;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public String toString() {
        return "use of following card: "+ getCard().getPan();
    }
}
