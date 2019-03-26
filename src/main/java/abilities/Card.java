package abilities;

import facts.CardType;

public class Card {
    private String pan;
    private String expDate;
    private int balance;
    private CardType type;



    public Card(String pan, String extDate, int balance, CardType type) {
        this.pan = pan;
        this.expDate = extDate;
        this.balance = balance;
        this.type = type;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExpDate() {
        return expDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPan() {
        return pan;
    }

    public CardType getType() {
        return type;
    }
}
