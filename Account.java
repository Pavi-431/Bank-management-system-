import java.io.Serializable;

class Account implements Serializable {
    private String accountNumber;
    private String name;
    private double balance;

    public Account(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited. New balance: ₹" + balance);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn. New balance: ₹" + balance);
            return true;
        }
    }

    @Override
    public String toString() {
        return accountNumber + " | " + name + " | ₹" + balance;
    }
}
