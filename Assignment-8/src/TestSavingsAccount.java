
public class TestSavingsAccount {
    public static void main(String[] args) {
        SavingsAccount.modifyInterestRate(0.04);

        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        System.out.println("Initial balances:");
        System.out.printf("Saver1: $%.2f\n", saver1.getSavingsBalance());
        System.out.printf("Saver2: $%.2f\n\n", saver2.getSavingsBalance());

        for (int month = 1; month <= 12; month++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("Month %d: \n", month);
            System.out.printf("  Saver1 balance: $%.2f\n", saver1.getSavingsBalance());
            System.out.printf("  Saver2 balance: $%.2f\n\n", saver2.getSavingsBalance());
        }

        SavingsAccount.modifyInterestRate(0.05);

        System.out.println("After changing interest rate to 5%:");
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("Saver1 balance: $%.2f\n", saver1.getSavingsBalance());
        System.out.printf("Saver2 balance: $%.2f\n", saver2.getSavingsBalance());
    }
}
