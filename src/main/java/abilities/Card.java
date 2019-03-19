package abilities;

public class Card {
    private String pam;
    private String expDate;
    private int balance;

    public Card(String pam, String extDate, int balance) {
        this.pam = pam;
        this.expDate = extDate;
        this.balance = balance;
    }

    public void setPam(String pam) {
        this.pam = pam;
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

    public String getPam() {
        return pam;
    }
}
