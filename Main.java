import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        try {
            while (true) {
                displayMenu();
                System.out.print("Select an option (1/2/3/4): ");
                String choice = scanner.nextLine();

                if (choice.equals("1")) {
                    System.out.print("Enter the withdrawal amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    if (bankAccount.withdraw(amount)) {
                        System.out.println("Withdrawal successful. New balance: " + bankAccount.checkBalance());
                    } else {
                        System.out.println("Insufficient funds or invalid amount for withdrawal.");
                    }
                } else if (choice.equals("2")) {
                    System.out.print("Enter the deposit amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    if (bankAccount.deposit(amount)) {
                        System.out.println("Deposit successful. New balance: " + bankAccount.checkBalance());
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                } else if (choice.equals("3")) {
                    System.out.println("Your current balance: " + bankAccount.checkBalance());
                } else if (choice.equals("4")) {
                    System.out.println("Thank you for using the ATM!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please select a valid option (1/2/3/4).");
                }
            }
        } finally {
            scanner.close(); 
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter your initial balance: ");
            double initialBalance = Double.parseDouble(input.nextLine());

            BankAccount userAccount = new BankAccount(initialBalance);
            ATM atm = new ATM(userAccount);
            atm.run();
        } finally {
            input.close(); 
        }
    }
}
