package tuan13;

public class BankAccount {
    private String name;
    private double balance;
    private String accountNumber;
    
    private static int numberOfAccount = 1;

    public BankAccount(String name, double balance) throws Exception {
        if (balance < 0) {
            throw new Exception("So du khong hop le (balance < 0)");
        }
        this.name = name;
        this.balance = balance;
        this.accountNumber = "0081" + padLeft(String.valueOf(numberOfAccount), 8, '0');
        numberOfAccount++;
    }

    public static String padLeft(String s, int n, char c) {
        return String.format("%" + n + "s", s).replace(' ', c);
    }

    public static String padRight(String s, int n, char c) {
        return String.format("%-" + n + "s", s).replace(' ', c);
    }

    public void output() {
        System.out.printf("%-15s %-25s %-15.1f\n", accountNumber, name, balance);
    }
}
