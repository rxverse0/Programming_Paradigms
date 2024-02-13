public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
        printBalance();
    }
    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient funds for withdrawal: " + amount);
        }
        printBalance();
    }
    private void printBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        Thread depositThread1 = new Thread(() -> account.deposit(100));
        Thread depositThread2 = new Thread(() -> account.deposit(200));
        Thread withdrawThread1 = new Thread(() -> account.withdraw(1150));
        Thread withdrawThread2 = new Thread(() -> account.withdraw(300));
        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();
    }
}

