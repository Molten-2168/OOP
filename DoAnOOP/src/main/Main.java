/*
Ho va Ten: Sỳ Chí Khởi
MSSV: 22502168
BÀI TẬP LỚN MÔN HỌC LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG
Chủ đề 9: Viết chương trình quản lý thông tin của sinh viên và giáo viên tại một trường đại học

*/
package main;

import java.util.Scanner;
import manager.UniversityManager;
import model.Student;
import model.Teacher;

public class Main {
    public static void main(String[] args) {
        UniversityManager manager = new UniversityManager();
        manager.loadData();
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n=== CHUONG TRINH QUAN LY TRUONG DAI HOC ===");
            System.out.println("1. Quan ly thong tin Sinh vien");
            System.out.println("2. Quan ly thong tin Giao vien");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("===========================================");
            System.out.print("Nhap lua chon cua ban: ");
            
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("-> Loi: Vui long nhap mot so nguyen!");
                continue;
            }

            switch (choice) {
                case 1:
                    menuSinhVien(manager, sc);
                    break;
                case 2:
                    menuGiaoVien(manager, sc);
                    break;
                case 0:
                    manager.saveData();
                    System.out.println("-> Dang thoat chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println("-> Loi: Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    private static void menuSinhVien(UniversityManager manager, Scanner sc) {
        int subChoice = -1;
        do {
            System.out.println("\n--- SUB-MENU: QUAN LY SINH VIEN ---");
            System.out.println("1. Them sinh vien moi");
            System.out.println("2. Xoa sinh vien");
            System.out.println("3. Sua thong tin sinh vien");
            System.out.println("4. Tim kiem sinh vien");
            System.out.println("5. Hien thi danh sach sinh vien");
            System.out.println("0. Quay lai Menu chinh");
            System.out.println("-----------------------------------");
            System.out.print("Nhap lua chon: ");
            
            try {
                subChoice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("-> Loi: Vui long nhap mot so nguyen!");
                continue;
            }

            switch (subChoice) {
                case 1:
                    System.out.println("\n-- NHAP THONG TIN SINH VIEN --");
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Ten: "); String name = sc.nextLine();
                    System.out.print("Dia chi: "); String address = sc.nextLine();
                    System.out.print("SDT: "); String phone = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Chuyen nganh: "); String major = sc.nextLine();
                    System.out.print("GPA: "); double gpa = nhapSoDouble(sc, "GPA: ");
                    
                    Student s = new Student(id, name, address, phone, email, major, gpa);
                    manager.addPerson(s);
                    break;
                case 2:
                    System.out.print("Nhap ID Sinh vien can xoa: ");
                    manager.deletePerson(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap ID Sinh vien can sua thong tin: ");
                    manager.editPerson(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap Ten Sinh vien can tim: ");
                    manager.searchPerson(sc.nextLine());
                    break;
                case 5:
                    manager.hienThiSinhVien();
                    break;
                case 0:
                    System.out.println("-> Quay lai Menu chinh.");
                    break;
                default:
                    System.out.println("-> Loi: Lua chon khong hop le!");
            }
        } while (subChoice != 0);
    }

    private static void menuGiaoVien(UniversityManager manager, Scanner sc) {
        int subChoice = -1;
        do {
            System.out.println("\n--- SUB-MENU: QUAN LY GIAO VIEN ---");
            System.out.println("1. Them giao vien moi");
            System.out.println("2. Xoa giao vien");
            System.out.println("3. Sua thong tin giao vien");
            System.out.println("4. Tim kiem giao vien");
            System.out.println("5. Hien thi danh sach giao vien");
            System.out.println("0. Quay lai Menu chinh");
            System.out.println("-----------------------------------");
            System.out.print("Nhap lua chon: ");
            
            try {
                subChoice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("-> Loi: Vui long nhap mot so nguyen!");
                continue;
            }

            switch (subChoice) {
                case 1:
                    System.out.println("\n-- NHAP THONG TIN GIAO VIEN --");
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Ten: "); String name = sc.nextLine();
                    System.out.print("Dia chi: "); String address = sc.nextLine();
                    System.out.print("SDT: "); String phone = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Khoa: "); String department = sc.nextLine();
                    System.out.print("Luong: "); double salary = nhapSoDouble(sc, "Luong: ");
                    
                    Teacher t = new Teacher(id, name, address, phone, email, department, salary);
                    manager.addPerson(t);
                    break;
                case 2:
                    System.out.print("Nhap ID Giao vien can xoa: ");
                    manager.deletePerson(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap ID Giao vien can sua thong tin: ");
                    manager.editPerson(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap Ten Giao vien can tim: ");
                    manager.searchPerson(sc.nextLine());
                    break;
                case 5:
                    manager.hienThiGiaoVien();
                    break;
                case 0:
                    System.out.println("-> Quay lai Menu chinh.");
                    break;
                default:
                    System.out.println("-> Loi: Lua chon khong hop le!");
            }
        } while (subChoice != 0);
    }
    
    private static double nhapSoDouble(Scanner sc, String tieuDe) {
        while (true) {
            try {
                System.out.print(tieuDe);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("-> Loi: Vui long nhap so (vi du: 3.5 hoac 1000)!");
            }
        }
    }
}

