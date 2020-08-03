/*
Vi du ve bieu thuc chinh qui:
- kiểm tra dữ liệu nhập vào có dang thuc hop le cua chuoi ho ten hay khong?
Ho ten hop le: khong co ky tu dac biet, khong co chua so - it nhat 1 ky tu, nhieu nhat 30 ky tu
 */
package demo;
import java.util.Scanner;
import java.util.regex.*;
public class Vidu1 {

    public static void main(String[] args) {
        // 1. tạo mẫu qui luật (qui tắc) cho chuỗi họ tên hợp lệ
        java.util.regex.Pattern p = Pattern.compile("[a-z A-Z]{1,30}");
        
        // 2. tạo đối tượng để thực hiện tính năng kiểm tra qui luật p với chuỗi văn bản bất kì
        java.util.regex.Matcher m = null;
        
        String hoten = " ";
        Scanner sc = new Scanner(System.in);
        while (true) {            
            System.out.print("Nhap ho ten sinh vien: ");
            hoten = sc.nextLine().trim();
            
            //3. khởi tạo đối tượng matcher m, để tiến hành việc kiểm tra so khop p với họ tên
            m = p.matcher(hoten);
            
            //4. đánh giá bằng hàm matches() hoàn toàn giống / lookingAt() chỉ cần xuất hiện ở chữ đầu tiên/ find()
            if (m.matches()) {
                System.out.println("Ten nhap hop le");
                break;
            }
            // thông báo lỗi
            System.out.println("Ten khong hop le. Vui long nhap lai!!!");
        }
    }
    
}
