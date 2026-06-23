package model;

public class Student extends Person {
    private String chuyenNganh;
    private double gpa;

    public Student() {
        super();
    }

    public Student(String id, String name, String address, String phone, String email, String chuyenNganh, double gpa) {
        super(id, name, address, phone, email); 
        this.chuyenNganh = chuyenNganh;
        this.gpa = gpa;
    }

    public String getChuyenNganh() { return chuyenNganh; }
    public void setChuyenNganh(String chuyenNganh) { this.chuyenNganh = chuyenNganh; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    // Ghi de abstract method lop Person (the hien tinh da hinh)
    @Override
    public void displayInfo() {
        System.out.println("--- THONG TIN SINH VIEN ---");
        System.out.println("ID: " + id);
        System.out.println("Ten: " + name);
        System.out.println("Dia chi: " + address);
        System.out.println("SDT: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Chuyen nganh: " + chuyenNganh);
        System.out.println("Diem trung binh (GPA): " + gpa);
        System.out.println("---------------------------");
    }
}