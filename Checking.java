/**
 * Checking
 */
public class Checking extends Account {

    private long debitCardNumber;
    private int debitCardPin;

    public Checking(String name, String ssn, double deposit) {
        super(name, ssn, deposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    private void setDebitCard() {
        debitCardNumber = (long)(Math.random() * Math.pow(10, 16));
        debitCardPin = (int)(Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
       System.out.println("ACCOUNT TYPE: Checking"); 
       super.showInfo();
       System.out.println("Features:\n\tDebit Card Number: " + debitCardNumber + "\n\tDebit Card Pin: " + debitCardPin);
        
    }
}