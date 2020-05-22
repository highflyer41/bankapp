import java.util.LinkedList;
import java.util.List;

public class BankDriver {
    
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<>();
        
        //Read a CSV file and create new accouns from that
        String file = "original.csv";
        List<String[]> newAccounts = ReadCSV.read(file);

        for(String[] ele : newAccounts) {
            //System.out.println("NEW ACOUNT *******");
            String name = ele[0];
            String ssn = ele[1];
            String accountType = ele[2];
            double initDeposit = Double.parseDouble(ele[3]);
            // System.out.printf("%s %s %s $%.2f\n", name, ssn, accountType, initDeposit);

            if(accountType.equalsIgnoreCase("Savings")) {
                accounts.add(new Savings(name, ssn, initDeposit));
            } else if(accountType.equalsIgnoreCase("Checking")) {
                accounts.add(new Checking(name, ssn, initDeposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for(Account ele : accounts) {
            System.out.println("\n**********************************");
            ele.showInfo();
        }

    }
}