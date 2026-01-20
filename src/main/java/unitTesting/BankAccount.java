package unitTesting;

public class BankAccount {
    private double balance;
    private double minimumBalance;
    private boolean isActive = true;
    private String holderName;

    /**
     * To run the test report, add plugins in pom, and run in console: mvn surefire-report:report
     * Go to target/site to see the report
     */


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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean status) {
        this.isActive = status;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String name) {
        this.holderName = name;
    }

}
