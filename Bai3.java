package tuan11;

import java.util.Scanner;

class Employee {
    private String name;
    private int yearOfBirth;
    private String address;

    public Employee() {
    }

    public Employee(String name, int yearOfBirth, String address) throws Exception {
        this.name = name;
        setYearOfBirth(yearOfBirth);
        setAddress(address);
    }

    public void setYearOfBirth(int newYOB) throws Exception {
        if (newYOB <= 0) {
            throw new Exception("Nam sinh phai la so nguyen duong.");
        }
        this.yearOfBirth = newYOB;
    }

    public void setAddress(String newAddr) throws Exception {
        if (newAddr == null || newAddr.length() > 50) {
            throw new Exception("Dia chi khong duoc vuot qua 50 ky tu.");
        }
        this.address = newAddr;
    }

    public void input(Scanner sc) {
        System.out.print("Nhap ten: ");
        this.name = sc.nextLine();
        
        // Vong lap ep nhap dung Nam sinh
        while (true) {
            try {
                System.out.print("Nhap nam sinh: ");
                int yob = Integer.parseInt(sc.nextLine());
                setYearOfBirth(yob); 
                break; 
            } catch (NumberFormatException e) {
                System.out.println("Loi: Nam sinh phai la so nguyen. Vui long nhap lai!");
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage() + " Vui long nhap lai!");
            }
        }

        // Vong lap ep nhap dung Dia chi
        while (true) {
            try {
                System.out.print("Nhap dia chi (toi da 50 ky tu): ");
                String addr = sc.nextLine();
                setAddress(addr);
                break;
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage() + " Vui long nhap lai!");
            }
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + " | YOB: " + yearOfBirth + " | Address: " + address;
    }

    public void output() {
        System.out.println(this.toString());
    }
}

public class Bai03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] ds = new Employee[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("\n   NHAP THONG TIN NHAN VIEN THU " + (i + 1) + "   ");
            ds[i] = new Employee();
            ds[i].input(sc); // Ham input tu dong xu ly exception va ep nhap lai neu sai
        }

        System.out.println("\n   DANH SACH NHAN VIEN HOP LE   ");
        for (Employee emp : ds) {
            emp.output();
        }
        
        sc.close();
    }
}
