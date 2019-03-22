package abilities;

public class Card {
    private String pan;
    private String expDate;
    private int balance;

    public Card(String pan, String extDate, int balance) {
        this.pan = pan;
        this.expDate = extDate;
        this.balance = balance;
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
}
