public class Savings extends Account {
    
    private int safetyDepositBoxId, safetyDepositBoxKey;

    public Savings(String name, String ssn, double deposit) {
        super(name, ssn, deposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxId = (int)((Math.random()*900)+100);
        safetyDepositBoxKey = (int)((Math.random()*9000)+1000);
    }

    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Savings");
        super.showInfo();
        System.out.println("Features:\n\tSafety Deposit Box ID: " + safetyDepositBoxId + "\n\tSafety Deposit Box Key: " + safetyDepositBoxKey);
        
    }
}