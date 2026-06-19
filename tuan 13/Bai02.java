package tuan13;

import java.util.ArrayList;

public class Bai02 {
    public static void main(String[] args) {
        ArrayList<BankAccount> list = new ArrayList<>();
        
        System.out.println("--- KHOI TAO DANH SACH TAI KHOAN ---");
        
        Object[][] testData = {
            {"Sy Chi Khoi", 5000000.0},
            {"Tran Thanh Dat", -100000.0}, 
            {"Nguyen Van A", 1500000.0},
            {"Le Thi B", -50.0},           
            {"Hoang Van C", 0.0}
        };

        for (Object[] data : testData) {
            String name = (String) data[0];
            double balance = (double) data[1];
            
            try {
                BankAccount acc = new BankAccount(name, balance);
                list.add(acc);
            } catch (Exception e) {
                System.out.println("Khong the tao tai khoan cho [" + name + "]: " + e.getMessage());
            }
        }

        System.out.println("\n--- DANH SACH TAI KHOAN HOP LE ---");
        System.out.printf("%-15s %-25s %-15s\n", "ACCOUNT NUMBER", "NAME", "BALANCE");
        System.out.println("---------------------------------------------------------");
        
        for (BankAccount acc : list) {
            acc.output();
        }
    }
}
