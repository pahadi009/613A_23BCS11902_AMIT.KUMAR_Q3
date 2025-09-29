import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    // Constructor to initialize the account
    public BankAccount(String accountHolderName, int accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
        }
    }

    // Withdraw method (returns true if successful, false if insufficient balance)
    public boolean withdraw(double amount) {
        if (amount >= 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read account holder's name (can include spaces)
        String accountHolderName = scanner.nextLine();

        try {
            // Read other inputs
            int accountNumber = scanner.nextInt();
            double initialBalance = scanner.nextDouble();
            double depositAmount = scanner.nextDouble();
            double withdrawAmount = scanner.nextDouble();

            // Validate input constraints
            if (accountNumber <= 0 || initialBalance < 0 || depositAmount < 0 || withdrawAmount < 0) {
                System.out.println("Invalid Input values");
                return;
            }

            // Create account
            BankAccount account = new BankAccount(accountHolderName, accountNumber, initialBalance);

            // Deposit
            account.deposit(depositAmount);

            // Attempt withdrawal
            if (!account.withdraw(withdrawAmount)) {
                System.out.println("Insufficient balance");
            } else {
                System.out.println(account.getBalance());
            }

        } catch (Exception e) {
            System.out.println("Invalid Input values");
        }

        scanner.close();
    }
}
