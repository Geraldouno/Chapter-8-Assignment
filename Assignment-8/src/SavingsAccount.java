
public class SavingsAccount {
    private static double annualInterestRate;

    private double savingsBalance;

    public SavingsAccount(double balance) {
        this.savingsBalance = balance;
    }

    // Method to calculate and add monthly interest to savings balance
    public void calculateMonthlyInterest() {
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += monthlyInterest;
    }

    // Static method to modify the annual interest rate for all account holders
    public static void modifyInterestRate(double newInterestRate) {
        annualInterestRate = newInterestRate;
    }

    // Method to get the current savings balance
    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Static method to get the current annual interest rate
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
}

