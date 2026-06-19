package tuan12;

import java.util.Scanner;

public class Account {
    // Bien static de tu dong tang so tai khoan cho tat ca doi tuong
    private static long nextAccountNumber = 8103000000L; 
    
    private String accountNumber;
    private String name;
    private String cellphone;
    private double balance;

    [span_1](start_span)// Constructor mac dinh, tu dong cap phat so tai khoan[span_1](end_span)
    public Account() {
        this.accountNumber = String.valueOf(nextAccountNumber++);
    }

    [span_2](start_span)// Constructor 3 tham so, co kiem tra so du am[span_2](end_span)
    public Account(String name, String cellphone, double balance) throws Exception {
        if (balance < 0) {
            throw new Exception("So du khong the am");
        }
        this.accountNumber = String.valueOf(nextAccountNumber++);
        this.name = name;
        this.cellphone = cellphone;
        this.balance = balance;
    }

    // --- Getters & Setters ---
    public String getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    [span_3](start_span)// Ham nhap thong tin co chong loi nhap lieu[span_3](end_span)
    public void input(Scanner sc) {
        System.out.print("Nhap ten chu tai khoan: ");
        this.name = sc.nextLine();
        
        System.out.print("Nhap so di dong: ");
        this.cellphone = sc.nextLine();
        
        [span_4](start_span)// Vong lap ep nguoi dung nhap so du dung dinh dang[span_4](end_span)
        while (true) {
            try {
                System.out.print("Nhap so du ban dau: ");
                double bal = Double.parseDouble(sc.nextLine());
                if (bal < 0) {
                    throw new Exception("So du khong the am");
                }
                this.balance = bal;
                break; // Thoat vong lap neu nhap hop le
            } catch (NumberFormatException e) {
                System.out.println("Loi: Dinh dang so khong hop le. Vui long nhap lai!");
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage() + ". Vui long nhap lai!");
            }
        }
    }

    [span_5](start_span)// Ham nop tien[span_5](end_span)
    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("So tien khong hop le");
        }
        this.balance += amount;
        System.out.println("Nop tien thanh cong! So du hien tai: " + this.balance);
    }

    [span_6](start_span)// Ham rut tien[span_6](end_span)
    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("So tien khong hop le");
        }
        if (amount > this.balance) {
            throw new Exception("Tai khoan khong du tien");
        }
        this.balance -= amount;
        System.out.println("Rut tien thanh cong! So du hien tai: " + this.balance);
    }

    // Ham in thong tin tai khoan
    public void display() {
        System.out.printf("%-15s %-20s %-15s %-15.1f\n", 
                accountNumber, name, cellphone, balance);
    }
  }
