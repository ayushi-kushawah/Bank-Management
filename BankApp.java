import java.util.Scanner;

public class BankApp {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String number = sc.nextLine();
        BankAccount account = new BankAccount(name, number, 0);

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Transfer\n5. Account Info\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter deposit amount: ");
                    double amount = sc.nextDouble();
                    account.deposit(amount);
                    System.out.println("Deposited ₹" + amount);
                }
                case 2 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = sc.nextDouble();
                    if (account.withdraw(amount)) System.out.println("Withdrawn ₹" + amount);
                    else System.out.println("Insufficient balance");
                }
                case 3 -> System.out.println("Current Balance: ₹" + account.getBalance());
                case 4 -> {
                    System.out.print("Enter recipient account holder name: ");
                    String rName = sc.nextLine();
                    System.out.print("Enter recipient account number: ");
                    String rNumber = sc.nextLine();
                    BankAccount recipient = new BankAccount(rName, rNumber, 0);
                    System.out.print("Enter transfer amount: ");
                    double amount = sc.nextDouble();
                    if (account.transfer(recipient, amount)) {
                        System.out.println("Transferred ₹" + amount + " to " + rName);
                        System.out.println("Recipient Balance: ₹" + recipient.getBalance());
                    } else System.out.println("Transfer failed: Insufficient balance");
                }
                case 5 -> account.displayInfo();
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
