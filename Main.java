
class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | Current Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | Current Balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal: " + amount);
        }
    }
}

class DepositThread extends Thread {
    private BankAccount account;

    public DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            int amount = (int) (Math.random() * 100) + 1;
            account.deposit(amount);
            try {
                Thread.sleep(100); // Simulating some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;

    public WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            int amount = (int) (Math.random() * 50) + 1;
            account.withdraw(amount);
            try {
                Thread.sleep(150); // Simulating some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        DepositThread depositThread = new DepositThread(account);
        WithdrawThread withdrawThread = new WithdrawThread(account);

        depositThread.start();
        withdrawThread.start();
    }
}