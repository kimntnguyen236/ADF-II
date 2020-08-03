package basic;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    /*
    Các fields dữ liệu:
            i. String id, name, phone, address
            ii. int yob
    */
    public String id,name, phone, address;
    int yob;
    
    // hàm dựng

    public Customer() {
    }
    
    // hàm nhập dữ liệu chi tiết cho 1 khách hàng
    public void input(){
        Scanner sc = new Scanner(System.in); // khởi tạo biến đối tượng Scanner để thực hiện lệnh nhập liệu từ bàn phím
        
        // 1. nhập và kiểm tra id khách hàng: Cxxxx với x là ký số.
        Pattern p1 = Pattern.compile("C\\d{4}"); // tạo mẫu chính qui
        Matcher m1 = null; // khai báo đối tượng so khớp m1
        while (true) {            
            try {
                System.out.print("Nhap id: ");
                id = sc.nextLine().trim();
                m1 = p1.matcher(id); //khởi tạo m1 - để so khớp với mẫu p1 với id
                
                //thực hiện so khớp
                if (m1.matches()) {
                    break; // nếu id có nội dung trùng khớp với mẫu p1: dữ liệu nhập hợp lệ -> thoát khỏi vòng lặp nhập id
                }
                else{
                    // ném lỗi sai nhập liệu
                    throw new InvalidDataException("ID phải có dạng Cxxxx, với x là 1 ký số ! ");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: "+e.getMessage());
            }
        }// kết thúc while
        
        // 2. Nhập và kiểm tra tên KH: ít nhất 2 ký tự chữ A-Z
        p1= Pattern.compile("[ a-zA-Z]{2,}"); // khởi tạo lại mẫu chính qui
        m1 = null;
        while (true) {            
            try {
                System.out.print("Nhap ten khach hang: ");
                name = sc.nextLine().trim();
                m1 = p1.matcher(name); // khởi tạo m1 - để so khớp mẫu p2 với name
                // thực hiện so khớp
                if (m1.matches()) {
                    break; // nếu name có nội dung trùng khớp với mẫu p1: dữ liệu nhập hợp lệ -> thoát vòng lặp
                } else {
                    // ném lỗi sai nhập liệu
                    throw new InvalidDataException("Tên phải có ít nhất 2 ký tự chữ A-Z ! ");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: "+e.getMessage());
            }
        }
        
        // 3. nhập và kiểm tra số dt khách hàng : từ 3 - 10 số
        p1 = Pattern.compile("\\d{3,10}"); // khởi tạo lại mẫu chính qui
        m1 = null;
        while (true) {            
            try {
                System.out.print("Nhap số điện thoại: ");
                phone = sc.nextLine().trim();
                m1 = p1.matcher(phone); // khởi tạo m1 - để so khớp mẫu p1 với phone
                // thực hiện so khớp
                if (m1.matches()) {
                    break;
                }
                else{
                    // ném lỗi sai nhập liệu
                    throw new InvalidDataException("Số điện thoại có từ 3 -> 10 ký số ! ");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: "+e.getMessage());
            }
        }
        
        // 4. Nhập địa chỉ khách hàng
        System.out.print("Nhap địa chỉ: ");
        address = sc.nextLine().trim();
        
        // 5. Nhập năm sinh
        int namHienTai = java.time.Year.now().getValue();
        int tuoi = 0;
        while (true) {            
            try {
                System.out.print("Nhap năm sinh: ");
                yob = Integer.parseInt(sc.nextLine().trim());
                tuoi = namHienTai - yob;
                if (tuoi>=6 && tuoi<=100) {
                    break; // nếu năm sinh nhập hợp lệ -> thoát vòng lặp
                } else {
                    throw new InvalidDataException("Năm sinh không hợp lệ ! ");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: "+e.getMessage());
            }
        }
    }
    
    // "Q." -> "Quận"
    public String standarlizeAddress(){
        return address.replaceAll("(Q.|q.)","Quan");
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s - %d",id,name,standarlizeAddress(),phone,yob);
    }
    
    
}
