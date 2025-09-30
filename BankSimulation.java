import java.util.ArrayList;
import java.util.Scanner;

// Account class to manage banking operations
class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
            System.out.println("✅ Successfully deposited: " + amount);
        } else {
            System.out.println("❌ Deposit amount must be greater than 0.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " | Balance: " + balance);
            System.out.println("✅ Successfully withdrew: " + amount);
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("💰 Current Balance: " + balance);
    }

    // Show transaction history
    public void showTransactions() {
        System.out.println("\n📜 Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Main class
public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create account
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit: ");
        double initialDeposit = sc.nextDouble();
        Account account = new Account(name, initialDeposit);

        int choice;
        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    account.showTransactions();
                    break;

                case 5:
                    System.out.println("👋 Thank you for banking with us!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
