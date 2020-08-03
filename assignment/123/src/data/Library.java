package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    ArrayList<Book> pList = new ArrayList<Book>();

    public static void main(String[] args) {
        Library o = new Library();
        o.menu();
    }

    public void menu() {
        Library o = new Library();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String op = "";
            System.out.println("\n ===== MENU =====");
            System.out.println("1. Them");
            System.out.println("2. Xem");
            System.out.println("3. Xoa");
            System.out.println("4. Thoát");
            System.out.print("Chọn [1-4]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    o.addBook();
                    break;
                case "2":
                    o.viewAll();
                    break;
                case "3":
                    System.out.print("Nhập id sách cần xóa: ");
                    o.deleteBook(sc.nextLine().trim());
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Nhập không hợp lệ! Vui lòng kiểm tra và nhập lại!!!");
            }
        }

    }

    public void addBook() {
        Book p=new Book();
        p.acceptBook();
        pList.add(p);
        
        if(BookDAO.Insert(p)>0){
            System.out.println("Thêm thành công");
        }
        else{
            System.out.println("Đã xảy ra lỗi !! Thêm thất bại");
        }
    }

    public void viewAll() {
        List<Book> empList = BookDAO.getList();
        if (pList.isEmpty()) {
            System.out.println("Hệ thống chưa có dữ liệu !!");
            return;
        }
        System.out.println("\n>> Danh sách sách <<");
        empList.stream().forEach(System.out::println);
    }

    public void deleteBook(String s) {
        if (BookDAO.Delete(s) > 0) {
            System.out.println("Đã xóa thành công sách có id " + s);
        } else {
            System.out.println("Đã xảy ra lỗi !!! Không thể xóa sách có id " + s);
    }
}
}
