package tuan11;

class Converter {
    public static int stringToInt(String s) throws Exception {
        int result = 0;
        try {
            result = Integer.parseInt(s);
        } catch (Exception ex) {
            if (s == null) {
                result = 0;
            } else if (s.trim().equals("")) {
                result = 0;
            } else {
                throw ex; // Nem loi ra ngoai neu khong xu ly duoc
            }
        }
        return result;
    }

    public static double stringToDouble(String s) throws Exception {
        double result = 0;
        try {
            result = Double.parseDouble(s);
        } catch (Exception ex) {
            if (s == null) {
                result = 0;
            } else if (s.trim().equals("")) {
                result = 0;
            } else {
                throw ex; // Nem loi ra ngoai neu khong xu ly duoc
            }
        }
        return result;
    }
}

public class Bai02 {
    public static void main(String[] args) {
        // Danh sach cac chuoi can kiem tra theo de bai
        String[] arr = {"  ", null, "a123", "123", "1.23", "1.23d", "1.23f", "1.23a"};
        
        System.out.println("   TEST CHUYEN DOI STRING SANG INT   ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("S" + (i + 1) + " = " + (arr[i] == null ? "null" : "\"" + arr[i] + "\"") + " -> ");
            try {
                int res = Converter.stringToInt(arr[i]);
                System.out.println("Ket qua: " + res);
            } catch (Exception e) {
                System.out.println("Loi Exception: " + e.toString());
            }
        }

        System.out.println("\n   TEST CHUYEN DOI STRING SANG DOUBLE   ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("S" + (i + 1) + " = " + (arr[i] == null ? "null" : "\"" + arr[i] + "\"") + " -> ");
            try {
                double res = Converter.stringToDouble(arr[i]);
                System.out.println("Ket qua: " + res);
            } catch (Exception e) {
                System.out.println("Loi Exception: " + e.toString());
            }
        }
    }
}
