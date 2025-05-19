import java.util.Scanner;

class BankAccount {
    private final String name;
    private final String accountNumber;
    private double balance;

    public BankAccount(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class MiniBankingSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Welcome to Mini Banking System!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your account number: ");
        String accNum = scanner.nextLine();

        BankAccount account = new BankAccount(name, accNum);

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View Account Details");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> account.showDetails();
                case 2 -> System.out.println("Your Balance: ₹" + account.getBalance());
                case 3 -> {
                    System.out.print("Enter amount to deposit: ₹");
                    double dep = scanner.nextDouble();
                    account.deposit(dep);
                }
                case 4 -> {
                    System.out.print("Enter amount to withdraw: ₹");
                    double with = scanner.nextDouble();
                    account.withdraw(with);
                }
                case 5 -> System.out.println("Thank you for using Mini Banking System!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
}
