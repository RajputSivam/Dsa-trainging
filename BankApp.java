import java.util.*;

class Account {
    long number;
    String name;
    double balance;

    Account(long number, String name, double balance) {
        this.number = number;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amt) { balance += amt; }

    boolean withdraw(double amt) {
        if (amt > balance) return false;
        balance -= amt;
        return true;
    }

    void show() {
        System.out.println(number + " | " + name + " | " + balance);
    }
}

public class BankApp {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> list = new ArrayList<>();
    static long nextNum = 1001;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. View All\n0. Exit");
            System.out.print("Choose: ");

            switch (sc.nextInt()) {
                case 1 -> create();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> view();
                case 0 -> { System.out.println("Bye!"); return; }
                default -> System.out.println("Invalid!");
            }
        }
    }

    static void create() {
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Initial deposit: ");
        double bal = sc.nextDouble();

        Account a = new Account(nextNum++, name, bal);
        list.add(a);
        System.out.println("Created. Acc No: " + a.number);
    }

    static Account find(long num) {
        for (Account a : list)
            if (a.number == num) return a;
        return null;
    }

    static void deposit() {
        System.out.print("Account number: ");
        Account a = find(sc.nextLong());

        if (a == null) { System.out.println("Not found!"); return; }

        System.out.print("Amount: ");
        a.deposit(sc.nextDouble());
        System.out.println("Deposit done.");
    }

    static void withdraw() {
        System.out.print("Account number: ");
        Account a = find(sc.nextLong());

        if (a == null) { System.out.println("Not found!"); return; }

        System.out.print("Amount: ");
        if (a.withdraw(sc.nextDouble()))
            System.out.println("Withdraw done.");
        else
            System.out.println("Insufficient balance!");
    }

    static void view() {
        if (list.isEmpty()) {
            System.out.println("No accounts.");
            return;
        }
        for (Account acc : list)
        {
            acc.show();
        }
    }
}
