
import java.util.*;
import java.io.*;
/*
a. Các fields dữ liệu:
HashSet<Book> bkList để lưu tất cả các quyển sách trong thư viện.
b. Method :
1. void add() : thêm 1 sách mới vô bkList. Yêu cầu kiểm tra trùng mã .
2. void remove( String bkID ) : Xóa 1 quyển sách có mã số bkID ra khỏi bkList.
3. void display() : In danh mục các quyển sách trong thư viện .
4. void display( String auName ) : Tìm và in ra các quyển sách có của tác giả có tên auName
 */

public class BookCatalog {
    Set<Book> bkList = new HashSet<>();
    
    public void add(){
        Book b = new Book();
        b.input();
        if (bkList.contains(b.id)) {
            System.out.println("Id đã tồn tại ! Từ chối !");
            return;
        }
        bkList.add(b);
    }
    
    public void remove(String bkID) {
        int cnt=0;
        
        for(Book item:bkList){
            if(item.id.equalsIgnoreCase(bkID)){
                bkList.remove(item);
                cnt++;
            }
        }
        if(cnt==0){
            System.out.println("Không tìm thấy sách cần xóa");
        }
        else{
            System.out.println("Đã xóa "+cnt+" sách có chứa "+bkID);
        }
    }
    
    public void display() {
        if (bkList.isEmpty()) {
            System.out.println("He thong chua co du lieu");
            return;// ket thuc ham
        }
        System.out.println("\n Cách 1");
        System.out.println(">>Danh sách các cuốn sách");
        for(Book item:bkList){
            System.out.println(item);
        }
        
        System.out.println("\n Cách 2");
        bkList.stream().forEach(System.out::println);
    }
    
    public void display(String auName) {
        if (bkList.isEmpty()) {
            System.out.println("He thong chua co du lieu");
            return;// ket thuc ham
        }
        int dem = 0;
        String tacgia = auName.toLowerCase();
        for (Book book : bkList) {
            if (book.author.toLowerCase().contains(tacgia)) {
                System.out.println(book.toString());
                dem++;
            }
        }
        if (dem > 0) {
            System.out.println("Tim thay " + dem + " quyển sách có của tác giả có tên " + tacgia);
        } else {
            System.out.println("khong co quyển sách của tác giả có tên "+tacgia);
        }
    }
    
    String tenFile = "book.txt";
    public void saveFile() {
        try {
            java.io.PrintWriter pw = new PrintWriter(tenFile);
            // lấy hết dữ liệu bs ra sau đó lưu vô tập tin này
            for (Book item : bkList) {
                pw.println(item);
                
            }
            pw.close(); // thiếu câu lệnh này, dữ liệu sẽ không được lưu vào trong tệp tin. QUAN TRỌNG
        } catch (Exception ex) {
            System.out.println("Loi sai: " + ex.getMessage());
        }
        
        // sau khi ghi file xong - xem nội dung của file này trong chương trình NOTEPAD
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("notepad "+ tenFile); // notepad phải có khoảng trắng
        } catch (IOException ex) {
            System.out.println("Loi: "+ex.getMessage());
        }
    }
    
}
