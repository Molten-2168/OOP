package manager;

import java.util.ArrayList;
import java.util.Scanner;
import model.Person;
import model.Student;
import model.Teacher;

public class UniversityManager implements IPersonManager {
    private ArrayList<Person> danhSach;

    //khoi tao danh sach
    public UniversityManager() {
        danhSach = new ArrayList<>();
    }

    @Override
    public void addPerson(Person p) {
        danhSach.add(p); 
        System.out.println("-> Them thanh cong vao he thong!");
    }

    @Override
    public void editPerson(String id) {
        boolean timThay = false;
        Scanner sc = new Scanner(System.in);
        for (Person p : danhSach) {
            if (p.getId().equals(id)) {
                timThay = true;
                System.out.println("-> Dang sua thong tin cho ID: " + id);
                System.out.print("Nhap ten moi: "); p.setName(sc.nextLine());
                System.out.print("Nhap dia chi moi: "); p.setAddress(sc.nextLine());
                System.out.print("Nhap SDT moi: "); p.setPhone(sc.nextLine());
                System.out.print("Nhap Email moi: "); p.setEmail(sc.nextLine());
                System.out.println("-> Cap nhat thong tin thanh cong!");
                break;
            }
        }
        if (!timThay) System.out.println("-> Loi: Khong tim thay ID nay.");
    }

    @Override
    public void deletePerson(String id) {
        boolean timThay = false;
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getId().equals(id)) {
                danhSach.remove(i); 
                timThay = true;
                System.out.println("-> Da xoa thanh cong ID: " + id);
                break;
            }
        }
        if (!timThay) System.out.println("-> Loi: Khong tim thay ID nay de xoa.");
    }

    @Override
    public void searchPerson(String name) {
        boolean timThay = false;
        System.out.println("-> Ket qua tim kiem: '" + name + "'");
        for (Person p : danhSach) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                p.displayInfo();
                timThay = true;
            }
        }
        if (!timThay) System.out.println("-> Khong co ai ten nhu vay.");
    }

    @Override
    public void displayAll() {
        if (danhSach.isEmpty()) { 
            System.out.println("-> Danh sach hien tai dang trong!");
            return;
        }
        for (Person p : danhSach) {
            p.displayInfo();
        }
    }

    public void hienThiSinhVien() {
        int dem = 0;
        for (Person p : danhSach) {
            if (p instanceof Student) { 
                p.displayInfo();
                dem++;
            }
        }
        if (dem == 0) System.out.println("-> Chua co Sinh vien nao.");
    }

    public void hienThiGiaoVien() {
        int dem = 0;
        for (Person p : danhSach) {
            if (p instanceof Teacher) {
                p.displayInfo();
                dem++;
            }
        }
        if (dem == 0) System.out.println("-> Chua co Giao vien nao.");
    }

    //ket noi voi file manager
    public void loadData() {
        this.danhSach = FileManager.docFile();
        System.out.println("-> Da tai du lieu tu file text thanh cong!");
    }

    public void saveData() {
        FileManager.ghiFile(this.danhSach);
    }
}