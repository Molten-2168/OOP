package tuan11;

import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        
        System.out.println("   KIEM TRA SO NGUYEN   ");
        while (true) {
            System.out.print("Nhap mot so nguyen tu 50-100: ");
            try {
                // Ep kieu chuoi sang so nguyen
                n = Integer.parseInt(sc.nextLine());
                
                // Kiem tra dieu kien gioi han
                if (n >= 50 && n <= 100) {
                    break; // Thoat vong lap neu dung
                } else {
                    System.out.println("So vua nhap khong hop le. Vui long nhap lai.");
                }
            } catch (Exception e) {
                // Bat loi neu nguoi dung nhap chu hoac ky tu dac biet
                System.out.println("So vua nhap khong phai la so nguyen. Vui long nhap lai.");
            }
        }
        
        System.out.println("Chuc mung! Ban da nhap dung so: " + n);
        sc.close();
    }
}
