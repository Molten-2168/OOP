package manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import model.Person;
import model.Student;
import model.Teacher;

public class FileManager {
    private static final String FILE_NAME = "data.txt";

    public static void ghiFile(ArrayList<Person> danhSach) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Person p : danhSach) {
                if (p instanceof Student) {
                    Student s = (Student) p;
                    // Format: Student,id,name,address,phone,email,major,gpa
                    bw.write("Student," + s.getId() + "," + s.getName() + "," + s.getAddress() + "," 
                            + s.getPhone() + "," + s.getEmail() + "," + s.getChuyenNganh() + "," + s.getGpa());
                } else if (p instanceof Teacher) {
                    Teacher t = (Teacher) p;
                    // Format: Teacher,id,name,address,phone,email,department,salary
                    bw.write("Teacher," + t.getId() + "," + t.getName() + "," + t.getAddress() + "," 
                            + t.getPhone() + "," + t.getEmail() + "," + t.getKhoa() + "," + t.getLuong());
                }
                bw.newLine(); // next person
            }
            
            bw.close();
            fw.close();
            System.out.println("-> Da luu du lieu thanh cong vao file: " + FILE_NAME);
        } catch (Exception e) {
            System.out.println("-> Loi khi ghi file: " + e.getMessage());
        }
    }

    public static ArrayList<Person> docFile() {
        ArrayList<Person> danhSach = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return danhSach; // Tra ve danh sach rong neu file chua ton tai
            }

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); 
                
                if (data.length == 8) {
                    if (data[0].equals("Student")) {
                        // 0:Loai, 1:ID, 2:Ten, 3:Dia chi, 4:SDT, 5:Email, 6:Nganh, 7:GPA
                        Student s = new Student(data[1], data[2], data[3], data[4], data[5], data[6], Double.parseDouble(data[7]));
                        danhSach.add(s);
                    } else if (data[0].equals("Teacher")) {
                        // 6:Khoa, 7:Luong
                        Teacher t = new Teacher(data[1], data[2], data[3], data[4], data[5], data[6], Double.parseDouble(data[7]));
                        danhSach.add(t);
                    }
                }
            }
            
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("-> Loi khi doc file: " + e.getMessage());
        }
        return danhSach;
    }
}