/*
Java Main class Library, thực hiện chức năng quản lý các quyển sách trong 1 HashSet<Book> , bao gồm :
a. Add() : Thêm 1 quyển sách mới vô HashSet - thông báo thành công nếu thêm mới hoàn tất, ngược lại thông báo lỗi mỗi khi nhập sai.
b. Display() : in danh mục sách trong thư viện bao gồm các cột:
Số thứ tự, Mã sách , Tên , Nhà xuất bản
c. Save()
Lưu danh mục sách trong HashSet vô tập tin văn bản.
Thông tin của mỗi quyển sách sẽ được ghi trên 1 dòng.
Sử dụng NotePad để xem nội dung tập tin này sau khi lưu xong.
d. Menu()
 */
package app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Library {

    public static void main(String[] args) {
        Library o =new Library();
        Scanner sc = new Scanner(System.in);
        String op="";
        while (true) {
            System.out.println("\n ==== MENU ====");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Xem danh mục sách trong thư viện");
            System.out.println("3. Save File");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng [1-4]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1":
                   o.add();
                    break;
                case "2":
                    o.display();
                    break;
                case "3":
                    o.save();
                    break;
                case "4":
                    return;
            }
        }
    }
    HashSet<Book> ds = new HashSet<>();
    public void add(){
        Book b = new Book();
        b.input();
        
        ds.add(b);
        System.out.println("Thêm sách mới thành công !");
        // check trùng dùng Hashcode
    }
    
    public void display(){
        if (ds.size()==0) {
            System.out.println("Hệ thống chưa có dữ liệu ! ");
            return;
        }
        
        System.out.println("\n Danh mục sách trong thư viện: ");
        int i =1;
        for (Book item : ds) {
            System.out.printf("%2d %s \n",i++,item);
            //i++;
        }
    }
    
    String fname = "thuviensach.txt";
    public void save(){
        try {
            PrintWriter pw = new PrintWriter(fname);
            ds.stream().forEach(pw::println);
            
            // viết theo dạng biểu thức lambda
            // ds.stream().forEach(item -> pw.println(item));
            
            // hoặc viết dưới dạng vòng lặp
            /* for (Book item : ds) {
                pw.println(item);
            } */
            pw.close(); // cực kì quan trọng vì lệnh chỉ mới nằm trong bộ đệm
            
            // mở notepad để xem nội dung của tập tin [thuviensach.txt]
            Runtime r = Runtime.getRuntime();
            r.exec("notepad    "+fname);
        } catch (Exception ex) {
            System.out.println("Loi: "+ex.getMessage());
        }
    }
}
// PrintStream: ghi theo dạng byte, PrintWrite ghi theo dạng mã kí tự (unicode)