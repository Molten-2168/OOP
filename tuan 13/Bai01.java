package tuan13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        System.out.println("--- 1. TAO SINH VIEN BANG CONSTRUCTOR ---");
        String[][] testData = {
            {"VT2052193", "Nguyen Thanh Dat"}, 
            {"VT123", "Tran Binh"},            
            {"IT1234567", "Nam"}               
        };

        for (String[] data : testData) {
            try {
                Student s = new Student(data[0], data[1]);
                list.add(s);
                System.out.println("Tao thanh cong: " + data[0] + " - " + data[1]);
            } catch (Exception e) {
                System.out.println("Khong the tao (" + data[0] + ", " + data[1] + "): " + e.getMessage());
            }
        }

        System.out.println("\n--- 2. NHAP SINH VIEN TU BAN PHIM ---");
        System.out.print("Nhap so luong sinh vien muon them (N): ");
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ":");
            Student s = new Student();
            s.input(sc); 
            list.add(s);
        }

        System.out.println("\n--- 3. DANH SACH SINH VIEN VUA NHAP ---");
        printHeader();
        for (Student s : list) {
            s.output();
        }

        System.out.println("\n--- 4. DANH SACH SAP XEP THEO ID GIAM DAN ---");
        Collections.sort(list); 
        printHeader();
        for (Student s : list) {
            s.output();
        }

        System.out.println("\n--- 5. DANH SACH SAP XEP THEO TEN VA HO TANG DAN ---");
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int nameCompare = s1.getFirstName().compareToIgnoreCase(s2.getFirstName());
                if (nameCompare == 0) {
                    return s1.getLastName().compareToIgnoreCase(s2.getLastName());
                }
                return nameCompare;
            }
        });
        printHeader();
        for (Student s : list) {
            s.output();
        }

        sc.close();
    }

    private static void printHeader() {
        System.out.printf("%-12s %-20s %15s %35s\n", "ID", "LAST NAME", "FIRST NAME", "EMAIL");
        System.out.println("-------------------------------------------------------------------------------------");
    }
}
