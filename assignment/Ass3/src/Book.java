
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;

/*
    a. Các fields dữ liệu:  
        i. String id, title, author, publisher
        ii. int pages, price
    b. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
    c. Method :
        - void input() : nhập chi tiết cho 1 quyển sách và kiểm tra dữ liệu hợp lệ như sau 
        - id : Bxxxx, với x là ký số.
        - title : tựa sách. ít nhất 2 ký tự chữ, số hoặc khoảng trắng.
        - author, pubisher : tên tác giả, nhà xuất bản: ko được để trống
        - pages: số trang , từ 5 – 2000.
        - price : đơn giá, >0
        - String toString() : override method này để biểu diễn nội dung của 1 đối tượng sách dưới dạng chuỗi.
 */
public class Book {

    public String id, title, author, publisher;
    public int pages, price;

    public Book() {
    }

    public Book(String id, String title, String author, String publisher, int pages, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.price = price;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        //id : Bxxxx, với x là ký số.
        Pattern p = Pattern.compile("B\\d{4}");
        Matcher m = null;
        while (true) {
            try {
                System.out.print("Nhập id: ");
                id = sc.nextLine().trim();
                m = p.matcher(id);
                if (m.matches()) {
                    break;
                }
                System.out.println("id : Bxxxx, với x là ký số.");
            } catch (Exception e) {
                System.out.println("Loi sai: " + e.getMessage());
            }
        } // kết thúc while

        //title : tựa sách. ít nhất 2 ký tự chữ, số hoặc khoảng trắng.
        p = Pattern.compile("[a-zA-z0-9 ]{2,}");
        m = null;
        while (true) {
            try {
                System.out.print("Nhập title: ");
                title = sc.nextLine().trim();
                m = p.matcher(title);
                if (m.matches()) {
                    break;
                }
                System.out.println("title ít nhất 2 ký tự chữ, số hoặc khoảng trắng.");
            } catch (Exception e) {
                System.out.println("Loi sai: " + e.getMessage());
            }
        } //kết thúc while

        //author, pubisher : tên tác giả, nhà xuất bản: ko được để trống
        p = Pattern.compile("[a-zA-z ]{1,}");
        m = null;
        while (true) {
            try {
                System.out.print("Nhập tên tác giả: ");
                author = sc.nextLine().trim();
                m = p.matcher(author);
                if (m.matches()) {
                    break;
                }
                System.out.println("tên tác giả ko được để trống");
            } catch (Exception e) {
                System.out.println("Loi sai: " + e.getMessage());
            }
        }

        p = Pattern.compile("[a-zA-Z ]{1,}");
        m = null;
        while (true) {
            try {
                System.out.print("Nhập nhà xuất bản: ");
                publisher = sc.nextLine().trim();
                m = p.matcher(publisher);
                if (m.matches()) {
                    break;
                }
                System.out.println("nhà xuất bản ko được để trống");
            } catch (Exception e) {
                System.out.println("Loi sai: " + e.getMessage());
            }
        }
        // pages: số trang , từ 5 – 2000.
        while (true) {
            try {
                System.out.print("Nhập số trang: ");
                pages = Integer.parseInt(sc.nextLine().trim());
                if (pages >= 5 && pages <= 2000) {
                    break;
                }
                System.out.println("số trang từ 5 – 2000.");
            } catch (Exception e) {
                System.out.println("Loi sai: " + e.getMessage());
            }
        }
        // price : đơn giá, >0
        while (true) {
            try {
                System.out.print("Nhập giá : ");
                price = Integer.parseInt(sc.nextLine().trim());
                if (price > 0) {
                    break;
                }
                System.out.println("đơn giá >0");
            } catch (Exception e) {
                System.out.println("Loi sai: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Id : %s - Title : %s - Author : %s - Publisher : %s - Pages : %d - Price : %d", id, title, author, publisher, pages, price);
    }

    @Override
    public boolean equals(Object obj) {
        Book b = (Book) obj;
        return this.id.equals(b.id);
    }

//    @Override
    public int hashCode() {
        return 100;
    }

}
