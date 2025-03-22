import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Accounts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double deposit = sc.nextDouble();
                    bank.createAccount(accNum, name, deposit);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    String accDeposit = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double amountDeposit = sc.nextDouble();
                    bank.deposit(accDeposit, amountDeposit);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    String accWithdraw = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double amountWithdraw = sc.nextDouble();
                    bank.withdraw(accWithdraw, amountWithdraw);
                    break;
                case 4:
                    bank.listAccounts();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using our bank.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
