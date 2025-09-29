import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, int accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Get balance
    public double getBalance() {
        return balance;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Read account holder name (line with spaces)
            String accountHolderName = scanner.nextLine();

            // Read account number and amounts
            int accountNumber = scanner.nextInt();
            double initialBalance = scanner.nextDouble();
            double depositAmount = scanner.nextDouble();
            double withdrawAmount = scanner.nextDouble();

            // Validate input constraints
            if (accountNumber <= 0 || initialBalance < 0 || depositAmount < 0 || withdrawAmount < 0) {
                System.out.println("Invalid Input values");
                return;
            }

            // Create the bank account
            BankAccount account = new BankAccount(accountHolderName, accountNumber, initialBalance);

            // Perform deposit
            account.deposit(depositAmount);

            // Perform withdrawal
            if (!account.withdraw(withdrawAmount)) {
                System.out.println("Insufficient balance");
            } else {
                System.out.println(account.getBalance());
            }

        } catch (Exception e) {
            // Catch input format issues (non-numeric where numeric expected)
            System.out.println("Invalid Input values");
        } finally {
            scanner.close();
        }
    }
}
