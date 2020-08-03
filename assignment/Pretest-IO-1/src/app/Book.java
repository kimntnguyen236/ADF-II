/*
a. Fields: BookID, Title, Price, Publisher
b. Methods:
i. public void input() : nhập dữ liệu chi tiết của 1 quyển sách. 
Yêu cầu kiểm tra: 
BookID : phải có định dạng Bxxxx 
Tilte : không được để trống 
Price : có giá trị từ 1 – 1000 
Publisher : là chuỗi “OUP” hoặc “CUP”
ii. toString(), trả về chuỗi mô tả thông tin chi tiết 1 quyển sách, có tên nhà xuất bản đã được thay thế bằng hàm standardizedPublisher()
iii. public String standardizedPublisher(), trả về 1 chuỗi thay thế các từ trong field Publisher “OUP” thành “Oxford University Press” “CUP” thành “Cambridge University Press”
 */
package app;

import java.io.Serializable;
import java.util.*;
import java.util.regex.*;

public class Book { // lưu trữ dưới dạng không phải text thì implements Serializable 

    public String bookID, title, publisher;
    public int price;

    public Book(String bookID, String title, String publisher, int price) {
        this.bookID = bookID;
        this.title = title;
        this.publisher = publisher;
        this.price = price;
    }

    public Book() {
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chi tiết một quyển sách: ");

        // BookID : phải có định dạng Bxxxx 
        while (true) {
            System.out.print("Nhập mã số [Bxxxx]: ");
            bookID = sc.nextLine().trim();
            if (Pattern.matches("B\\d{4}", bookID)) {
                break;
            }
        }
        // Tilte : không được để trống 
        while (true) {
            System.out.print("Nhập tựa sách: ");
            title = sc.nextLine().trim();
            if (title.length() > 0) {
                break;
            }
        }
        // Price : có giá trị từ 1 – 1000 
        while (true) {
            try {
                System.out.print("Nhập đơn giá [1-1000]: ");
                price = Integer.parseInt(sc.nextLine().trim());
                if (price > 1 && price < 1000) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }
        // Publisher : là chuỗi “OUP” hoặc “CUP”
        while (true) {
            System.out.print("Nhập nhà xuất bản [OUP|CUP]: ");
            publisher = sc.nextLine().trim().toUpperCase();
            if (Pattern.matches("(OUP|CUP)", publisher)) {
                break;
            }
        }
    }

    public String standardizedPublisher() {
        String s = null;
        s = publisher.equalsIgnoreCase("OUP") ? "Oxford University Press" : "Cambridge University Press";
        // toUpperCase nên giờ mình dùng equals cũng được
        // nếu cẩn thận thì dùng equalsIgnoreCase()
        /* switch (publisher) {
            case "OUP":
                s = "Oxford University Press";
                break;
            case "CUP":
                s = "Cambridge University Press";
                break;
        } */
        return s;
    }

    @Override
    public String toString() {
        return String.format("%6s  %-20s  %-30s  %5d", bookID,title,standardizedPublisher(),price); // canh phải +, canh trái 
    }


}
