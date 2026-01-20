package unitTesting;

public class BankAccount {
    private double balance;
    private double minimumBalance;

    public BankAccount (double initialBalance, double minimumBalance) {
        this.balance = initialBalance;
        this.minimumBalance = minimumBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public double withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            throw new IllegalArgumentException("Withdrawal would breach minimum balance");
        }
        balance -= amount;
        return balance;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

}
