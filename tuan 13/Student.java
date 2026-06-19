package tuan13;

import java.util.Scanner;

public class Student implements Comparable<Student> {
    private String id;
    private String name;

    // Constructor mac dinh
    public Student() {
    }

    // Constructor 2 tham so co nem ngoai le
    public Student(String id, String name) throws Exception {
        if (!isValidId(id)) {
            throw new Exception("Invalid id");
        }
        if (!isValidName(name)) {
            throw new Exception("Invalid name");
        }
        this.id = id;
        this.name = normalizeName(name);
    }

    // Kiem tra ID: 2 chu cai + 7 chu so
    private boolean isValidId(String id) {
        return id != null && id.matches("[a-zA-Z]{2}[0-9]{7}");
    }

    // Kiem tra Name: co it nhat 2 tu
    private boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        return name.trim().split("\\s+").length >= 2;
    }

    // Chuan hoa chuoi ten (xoa khoang trang thua)
    private String normalizeName(String name) {
        return name.trim().replaceAll("\\s+", " ");
    }

    // Lay ten (tu cuoi cung)
    public String getFirstName() {
        String[] arr = name.split("\\s+");
        return arr[arr.length - 1];
    }

    // Lay ho va ten lot
    public String getLastName() {
        String firstName = getFirstName();
        return name.substring(0, name.length() - firstName.length()).trim();
    }

    // Tao email theo format
    public String getEmail() {
        String[] arr = name.split("\\s+");
        StringBuilder initials = new StringBuilder();
        
        for (int i = 0; i < arr.length - 1; i++) {
            initials.append(arr[i].charAt(0));
        }
        
        String last4Id = id.substring(5);
        return getFirstName() + "." + initials.toString() + last4Id + "@sinhvien.hoasen.edu.vn";
    }

    // Nhap ID
    public void inputId(Scanner sc) {
        while (true) {
            System.out.print("Nhap ID (VD: VT2052193): ");
            String input = sc.nextLine();
            if (isValidId(input)) {
                this.id = input;
                break;
            } else {
                System.out.println("Loi: ID khong hop le. Vui long nhap lai!");
            }
        }
    }

    // Nhap Name
    public void inputName(Scanner sc) {
        while (true) {
            System.out.print("Nhap Ho Ten (It nhat 2 tu): ");
            String input = sc.nextLine();
            if (isValidName(input)) {
                this.name = normalizeName(input);
                break;
            } else {
                System.out.println("Loi: Ten phai co it nhat 2 tu. Vui long nhap lai!");
            }
        }
    }

    // Nhap tong hop
    public void input(Scanner sc) {
        inputId(sc);
        inputName(sc);
    }

    // Xuat thong tin
    public void output() {
        System.out.printf("%-12s %-20s %15s %35s\n", id, getLastName(), getFirstName(), getEmail());
    }

    // Getter
    public String getId() { return id; }

    // Sap xep giam dan theo ID
    @Override
    public int compareTo(Student other) {
        return other.id.compareTo(this.id);
    }
}
