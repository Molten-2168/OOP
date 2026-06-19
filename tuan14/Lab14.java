package tuan14;

import java.util.Scanner;

public class Lab14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- 1. TAO STUDENT THU 1 BANG CONSTRUCTOR ---");
        try {
            // Chieu dai ten "Sy Chi Khoi" la 11 ky tu (< 20) -> Hop le
            Student s1 = new Student("SK2026", "Sy Chi Khoi");
            System.out.println("Tao thanh cong!");
            System.out.println(s1.toString());
            System.out.println("(Email he thong lien ket: chikhoisy@gmail.com)");
        } catch (Exception e) {
            System.out.println("Loi tao sv 1: " + e.getMessage());
        }
        
        System.out.println("\n--- 2. TAO STUDENT THU 2 BANG HAM INPUT ---");
        Student s2 = new Student();
        s2.input(sc);
        System.out.println("\nThong tin Student vua nhap:");
        System.out.println(s2.toString());
        
        sc.close();
    }
}
