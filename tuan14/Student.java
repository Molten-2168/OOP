package tuan14;

import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private String email;

    // Constructor khong tham so
    public Student() {
    }

    // Constructor 2 tham so (Co nem ra ngoai le neu sai dieu kien)
    public Student(String id, String name) throws Exception {
        setId(id);
        setName(name);
    }

    // Setter cho ID voi dieu kien: 2 chu cai + 4 chu so
    public void setId(String id) throws Exception {
        if (id == null || !id.matches("^[a-zA-Z]{2}[0-9]{4}$")) {
            throw new Exception("ID phai dung dinh dang (2 chu cai + 4 chu so, VD: AB1234)");
        }
        this.id = id;
    }

    // Setter cho Name voi dieu kien: Chieu dai < 20
    public void setName(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Ten khong duoc de trong.");
        }
        
        // Loai bo khoang trang thua de tinh chinh xac chieu dai thuc te
        String normalizedName = name.trim().replaceAll("\\s+", " ");
        if (normalizedName.length() >= 20) {
            throw new Exception("Ten phai co chieu dai nho hon 20 ky tu.");
        }
        
        this.name = normalizedName;
        // Moi khi ten duoc cap nhat hop le, he thong se tu dong tao lai email
        generateEmail(); 
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    // Ham input: Bat buoc nguoi dung nhap den khi nao dung thi thoi
    public void input(Scanner sc) {
        while (true) {
            System.out.print("Nhap ID (VD: AB1234): ");
            try {
                setId(sc.nextLine());
                break; // Thoat vong lap neu set thanh cong
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhap Ho Ten (< 20 ky tu): ");
            try {
                setName(sc.nextLine());
                break; // Thoat vong lap neu set thanh cong
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }
    }

    // Ham tao ra email tu Name (VD: Tran Van Binh -> binh.tranvan@hoasen.edu.vn)
    private void generateEmail() {
        if (this.name == null || this.name.isEmpty()) return;
        
        String[] words = this.name.split(" ");
        if (words.length == 1) {
            this.email = words[0].toLowerCase() + "@hoasen.edu.vn";
            return;
        }
        
        // Lay ten (tu cuoi cung trong mang)
        String firstName = words[words.length - 1].toLowerCase();
        
        // Ghep ho va chu lot lai voi nhau
        StringBuilder rest = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            rest.append(words[i].toLowerCase());
        }
        
        this.email = firstName + "." + rest.toString() + "@hoasen.edu.vn";
    }

    // Ham xuat chuoi thong tin
    @Override
    public String toString() {
        return id + " - " + name + " - " + email;
    }
}
