package tuan11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Bai03 {
    
    // Ham ho tro tim kiem tai khoan theo So Tai Khoan
    private static Account findAccount(ArrayList<Account> list, String accNum) {
        for (Account acc : list) {
            if (acc.getAccountNumber().equals(accNum)) {
                return acc;
            }
        }
        return null; // Tra ve null neu khong tim thay
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accountList = new ArrayList<>();
        int choice = 0;

        do {
            System.out.println("\n   --- HE THONG QUAN LY TAI KHOAN NGAN HANG ---   ");
            System.out.println("1. Create Account");
            System.out.println("2. Display Account info");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Sort Account by name Ascending");
            System.out.println("6. Sort Account by balance Descending");
            System.out.println("7. Exit");
            System.out.print("Moi ban chon chuc nang (1-7): ");
            
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so nguyen!");
                continue;
            }

            switch (choice) {
                [span_8](start_span)case 1: // Create Account[span_8](end_span)
                    System.out.println("\n   --- TAO TAI KHOAN MOI ---   ");
                    Account newAcc = new Account();
                    newAcc.input(sc);
                    accountList.add(newAcc);
                    System.out.println("Tao tai khoan thanh cong! So TK cua ban la: " + newAcc.getAccountNumber());
                    break;

                [span_9](start_span)case 2: // Display Account info[span_9](end_span)
                    System.out.print("\nNhap so tai khoan can hien thi: ");
                    String accNumToDisplay = sc.nextLine();
                    Account accToDisplay = findAccount(accountList, accNumToDisplay);
                    
                    if (accToDisplay != null) {
                        System.out.println("\n   THONG TIN TAI KHOAN   ");
                        System.out.printf("%-15s %-20s %-15s %-15s\n", "So TK", "Ten", "So DT", "So Du");
                        accToDisplay.display();
                    } else {
                        System.out.println("Tai khoan nay khong ton tai");
                    }
                    break;

                [span_10](start_span)case 3: // Deposit[span_10](end_span)
                    System.out.print("\nNhap so tai khoan can nop tien: ");
                    String accNumToDeposit = sc.nextLine();
                    Account accToDeposit = findAccount(accountList, accNumToDeposit);
                    
                    if (accToDeposit != null) {
                        try {
                            System.out.print("Nhap so tien muon nop: ");
                            double depAmount = Double.parseDouble(sc.nextLine());
                            accToDeposit.deposit(depAmount);
                        } catch (NumberFormatException e) {
                            System.out.println("Loi: Dinh dang so tien khong hop le!");
                        } catch (Exception e) {
                            System.out.println("Loi: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Tai khoan nay khong ton tai");
                    }
                    break;

                [span_11](start_span)case 4: // Withdraw[span_11](end_span)
                    System.out.print("\nNhap so tai khoan can rut tien: ");
                    String accNumToWithdraw = sc.nextLine();
                    Account accToWithdraw = findAccount(accountList, accNumToWithdraw);
                    
                    if (accToWithdraw != null) {
                        try {
                            System.out.print("Nhap so tien muon rut: ");
                            double withAmount = Double.parseDouble(sc.nextLine());
                            accToWithdraw.withdraw(withAmount);
                        } catch (NumberFormatException e) {
                            System.out.println("Loi: Dinh dang so tien khong hop le!");
                        } catch (Exception e) {
                            System.out.println("Loi: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Tai khoan nay khong ton tai");
                    }
                    break;

                [span_12](start_span)case 5: // Sort Account by name Ascending[span_12](end_span)
                    if (accountList.isEmpty()) {
                        System.out.println("Danh sach tai khoan dang trong!");
                        break;
                    }
                    Collections.sort(accountList, new Comparator<Account>() {
                        @Override
                        public int compare(Account a1, Account a2) {
                            // Sap xep tang dan (A-Z) theo Ten
                            return a1.getName().compareToIgnoreCase(a2.getName());
                        }
                    });
                    System.out.println("\n   DANH SACH DA SAP XEP THEO TEN TANG DAN   ");
                    System.out.printf("%-15s %-20s %-15s %-15s\n", "So TK", "Ten", "So DT", "So Du");
                    for (Account a : accountList) {
                        a.display();
                    }
                    break;

                [span_13](start_span)case 6: // Sort Account by balance Descending[span_13](end_span)
                    if (accountList.isEmpty()) {
                        System.out.println("Danh sach tai khoan dang trong!");
                        break;
                    }
                    Collections.sort(accountList, new Comparator<Account>() {
                        @Override
                        public int compare(Account a1, Account a2) {
                            // Sap xep giam dan theo So Du
                            return Double.compare(a2.getBalance(), a1.getBalance());
                        }
                    });
                    System.out.println("\n   DANH SACH DA SAP XEP THEO SO DU GIAM DAN   ");
                    System.out.printf("%-15s %-20s %-15s %-15s\n", "So TK", "Ten", "So DT", "So Du");
                    for (Account a : accountList) {
                        a.display();
                    }
                    break;

                [span_14](start_span)case 7: // Exit[span_14](end_span)
                    System.out.println("Da thoat chuong trinh. Chuc ban mot ngay tot lanh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon tu 1 den 7!");
                    break;
            }
        } while (choice != 7);
        
        sc.close();
    }
}
