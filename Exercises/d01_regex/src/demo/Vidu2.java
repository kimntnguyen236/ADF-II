/*
Vi du ve bieu thuc chinh qui:
- kiểm tra số điện thoại có hợp lệ không?
Số điện thoại hợp lệ: chứa các ký số hoặc khoảng trắng ít nhất 3 số.
 */
package demo;
import java.util.Scanner;
import java.util.regex.*;
public class Vidu2 {

    public static void main(String[] args) {
        // 1. tạo mẫu qui luật (qui tắc) cho sđt hợp lệ
        java.util.regex.Pattern p = Pattern.compile("[0-9 ]{3,}");
        
        // 2. Tạo đối tượng kiểm tra
        Matcher m = null;
        
        Scanner sc = new Scanner(System.in);
        String phone="";
        
        while (true) {            
            System.out.print("Nhap so dien thoai: ");
            phone = sc.nextLine().trim();
            
            // 3. Khởi tạo m 
            m = p.matcher(phone);
            
            //4. Kiểm tra
            if (m.matches()) {
                System.out.println("Phone hop le !");
                break;
            }
            System.out.println("Phone nhap khong dung. Vui long nhap lai!!!");
        }
    }
    
}
