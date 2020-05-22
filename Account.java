public abstract class Account implements IBaseRate{
    
    private String name, socialSecurityNum;
    protected String accountNumber;
    private double balance;
    protected double rate;
    private static int index = 10000;

    public Account(String name, String ssn, double deposit) {
        this.name = name;
        this.socialSecurityNum = ssn;
        this.balance = deposit;

        //set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoSSN = socialSecurityNum.substring(socialSecurityNum.length() - 2, socialSecurityNum.length());
        int uniqueId = index;
        int rand = (int)((Math.random() * 900) + 100);

        return lastTwoSSN + uniqueId + rand;
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: " + accruedInterest);
        printBalance();
    }

    public void printBalance() {
        System.out.println("BALANCE: $" + balance);
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("Depositing: $" + amount);
        printBalance();

    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdraw: $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();
    }

    public void showInfo() {
        System.out.printf("NAME: %s\nACCOUNT NUMBER: %s\nBALANCE: %.2f\nRATE: %.2f%%\n", name, accountNumber, balance, rate);
    }
}