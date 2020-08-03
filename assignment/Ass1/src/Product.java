
import java.util.Scanner;
import java.util.regex.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

/*
a. Các fields dữ liệu:
i. String id, name, mfg
ii. int unitPrice, qoh
b. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
c. Method void input() : nhập và kiểm tra thông tin chi tiết cho sản phẩm :
- id : Fxxxx (food) hoặc Bxxxx (beverage), với x là ký số.
- name : ít nhất 2 ký tự.
- unitPrice, qoh > 0
- mfg: US hoặc VN hoặc TL
d. Method String standardlizeMFG() : trả về chuỗi mô tả đầy đủ tên quốc gia sản xuất của field
mfg: US => United State, VN => Vietnam, TL => Thailand
f. Override method toString() để biểu diễn nội dung của 1 đối tượng sp dưới dạng chuỗi, với nội
dung của field mfg được thay thế bằng hàm standardlizeMFG().
 */

public class Product implements Comparable<Product>{
    public String id,name,mfg;
    public int unitPrice,qoh;

    public Product() {
    }

    public Product(String id, String name, String mfg, int unitPrice, int qoh) {
        this.id = id;
        this.name = name;
        this.mfg = mfg;
        this.unitPrice = unitPrice;
        this.qoh = qoh;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile("[F|B]\\d{4}");
        Matcher m = null;
        while (true) {            
            try {
                System.out.print("Nhập id [Fxxxx or Bxxxx]: ");
                id = sc.nextLine().trim();
                m = p.matcher(id);
                if (m.matches()) {
                    break;
                } else {
                    throw new InvalidException("id : Fxxxx (Food) hoặc Bxxxx (Beverage), với x là ký số.");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: "+e.getMessage());
            }
        } // kết thúc while
        
        p = Pattern.compile("[a-zA-Z ]{2,}");
        m=null;
        while (true) {            
            try {
                System.out.print("Nhập name: ");
                name = sc.nextLine().trim();
                m = p.matcher(name);
                if (m.matches()) {
                    break;
                } else {
                    throw new InvalidException("ít nhất 2 ký tự.");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: "+e.getMessage());
            }
        } //kết thúc while
        
        while (true) {      
            try {
                System.out.print("Nhập unitPrice: ");
            unitPrice = Integer.parseInt(sc.nextLine().trim());
            if (unitPrice>0) {
                break;
            }
            else{
                throw new InvalidException("UnitPrice >0");
            }
            } catch (Exception e) {
                System.out.println("Loi sai: "+e.getMessage());
            }
            
        } //kết thúc while
        
        while (true) {            
            try {
                System.out.print("Nhập qoh: ");
                qoh = Integer.parseInt(sc.nextLine().trim());
                if (qoh>0) {
                    break;
                } else {
                    throw new InvalidException("qoh >0");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: "+e.getMessage());
            }
        }
        p = Pattern.compile("US|VN|TL",Pattern.CASE_INSENSITIVE);
        m = null;
        while (true) {            
            System.out.print("Nhập mfg: ");
            mfg = sc.nextLine().trim().toUpperCase();
            try {
                m = p.matcher(mfg);
                if (m.matches()) {
                    break;
                } else {
                    throw new InvalidException("US hoặc VN hoặc TL");
                }
            } catch (Exception e) {
                System.out.println("Loi sai: "+e.getMessage());
            }
        } //kết thúc while
    }
    
    public String standardlizeMFG(){
        String s = null;
        switch(mfg){
            case "US": s= "United State" ; break;
            case "VN": s= "VietNam"; break;
            case "TL": s= "ThaiLand"; break;
        }
        return s;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s - %d - %d - %s",id,name,unitPrice,qoh,standardlizeMFG());
    }
    
    //Check phần tử bị trùng
    
    @Override
    public boolean equals(Object obj) {
        Product p = (Product) obj;
        return this.id.equals(p.id);
    }
    
    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public int compareTo(Product o) {
        return this.id.compareTo(o.id);
    }
    
}
