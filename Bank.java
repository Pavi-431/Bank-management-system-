import java.util.ArrayList;
import java.util.List;

class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = FileManager.loadAccounts();
    }

    public void createAccount(String accountNumber, String name, double initialDeposit) {
        Account newAccount = new Account(accountNumber, name, initialDeposit);
        accounts.add(newAccount);
        FileManager.saveAccounts(accounts);
        System.out.println("Account created successfully!");
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
            FileManager.saveAccounts(accounts);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            if (acc.withdraw(amount)) {
                FileManager.saveAccounts(accounts);
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("Account Number | Name | Balance");
            for (Account acc : accounts) {
                System.out.println(acc);
            }
        }
    }
}
