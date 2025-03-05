
import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public Account(BigDecimal initialBalance) {
        if (initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
        } else {
            System.out.println("Deposit amount must be positive");
        }
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(balance) <= 0) {
            balance = balance.subtract(amount);
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal newBalance) {
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        balance = newBalance;
    }

    public String toString() {
        return "Account balance: $" + balance.toString();
    }

    public static void main(String[] args) {
        Account account = new Account(new BigDecimal("1000.50"));

        System.out.println(account);

        account.deposit(new BigDecimal("500.25"));
        System.out.println("After deposit: " + account);

        account.withdraw(new BigDecimal("200.75"));
        System.out.println("After withdrawal: " + account);

        account.withdraw(new BigDecimal("1500.00"));
        System.out.println("After invalid withdrawal attempt: " + account);

        account.setBalance(new BigDecimal("1200.00"));
        System.out.println("After setting new balance: " + account);
    }
}

