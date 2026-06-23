package model;

public class Teacher extends Person {
    private String khoa;
    private double luong;

    public Teacher() {
        super();
    }

    public Teacher(String id, String name, String address, String phone, String email, String khoa, double luong) {
        super(id, name, address, phone, email);
        this.khoa = khoa;
        this.luong = luong;
    }

    public String getKhoa() { return khoa; }
    public void setKhoa(String khoa) { this.khoa = khoa; }

    public double getLuong() { return luong; }
    public void setLuong(double luong) { this.luong = luong; }

    // Ghi de abstract method lop Person (The hien Tinh Da Hinh)
    @Override
    public void displayInfo() {
        System.out.println("--- THONG TIN GIAO VIEN ---");
        System.out.println("ID: " + id);
        System.out.println("Ten: " + name);
        System.out.println("Dia chi: " + address);
        System.out.println("SDT: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Khoa: " + khoa);
        System.out.println("Luong: " + luong);
        System.out.println("---------------------------");
    }
}