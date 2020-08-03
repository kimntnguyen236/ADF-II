/*
 demo collection đơn giản : List và Set
 */
package demo;

import java.util.*;

public class Vidu1 {

    public static void main(String[] args) {
        Vidu1 p = new Vidu1();
        p.demoLIST();
        p.demoSET();
        p.demoMAP();
    }
    
    void demoLIST(){
        // khai báo và khởi tạo 1 list chứa danh sách "tên" của sinh viên (kiểu String)
        List<String> hoten = new ArrayList<String>(); // <> giới haj tập hợp bên trong là kiểu String. Không phải mảng nên không dùng []
        
        // thêm du lieu vô ds
        hoten.add("Quynh Luong");
        hoten.add("Huy Nguyen");
        hoten.add("Tam Hoang");
        hoten.add("Huyen Nguyen");
        hoten.add("An Le");
        hoten.add("Nhan Le");
        hoten.add("Dung Ngo");
        hoten.add("Thu Vo");
        hoten.add("Kim Nguyen");
        hoten.add("Buu Loi");
        hoten.add("Huy Nguyen");
        
        
        // in ds du lieu trong ds - theo for i: giống như mảng truyền thống
        System.out.println("\n Danh sách họ tên sinh viên [LIST] - FOR I: ");
        for (int i = 0; i < hoten.size(); i++) {
            String tensv = hoten.get(i); // lấy được họ tên sinh viên đứng thứ i
            System.out.println(tensv);
        }
        
        System.out.println(">>> Tong so sv: "+hoten.size());
        
        //in ds du lieu trong ds - theo for-each
        System.out.println("\n Danh sách họ tên sinh viên [LIST] - FOR-EACH: ");
        for (String item : hoten) { // với mỗi phần tử trong ds họ tên gọi là item
            System.out.println(item);
        }
        
        System.out.println(">>> Tong so sv: "+hoten.size());
    }
    
    void demoSET(){
        Set<String> hoten = new HashSet<String>();
        
        hoten.add("Quynh Luong");
        hoten.add("Huy Nguyen");
        hoten.add("Tam Hoang");
        hoten.add("Huyen Nguyen");
        hoten.add("An Le");
        hoten.add("Nhan Le");
        hoten.add("Dung Doan");
        hoten.add("Thu Vo");
        hoten.add("Kim Nguyen");
        hoten.add("Buu Loi");
        hoten.add("Huy Nguyen");
        System.out.println(" \nDanh sach ten sinh vien [SET] - for each");
        for (String item : hoten) {
            System.out.println(item);
        }
        System.out.println(">>> Tong so sv: "+hoten.size());
    }
    
    void demoMAP(){
        // khai báo và khởi tạo 1 map chứa danh sách "maso" và "tên" của sinh viên (kiểu String)
        Map<String, String> hoten = new HashMap<String, String>(); // đây là hình thức khai báo generic <String>
        
        // thêm du lieu vô ds
        hoten.put("s1","Quynh Luong");
        hoten.put("s2","Huy Nguyen");
        hoten.put("s3","Tam Hoang");
        hoten.put("s4","Huyen Nguyen");
        hoten.put("s5","An Le");
        hoten.put("s6","Nhan Le");
        hoten.put("s7","Dung Ngo");
        hoten.put("s8","Thu Vo");
        hoten.put("s9","Kim Nguyen");
        hoten.put("s10","Buu Loi");
        hoten.put("s2","Huy Nguyen");
        
        System.out.println("\n Danh sách họ tên sinh viên [MAP] - FOR-EACH: ");
        for (String item : hoten.values()) { // với mỗi phần tử trong ds họ tên gọi là item
            System.out.println(item);
        }
        
        System.out.println(">>> Tong so sv: "+hoten.size());
        
        
         //in danh sach du lieu trong ds - theo for-each 
        System.out.println("\n Danh sach sinh vien [MAP] - FOR-EACH ");
        for (String maSV : hoten.keySet()) {
            System.out.printf("%5s - %s \n", maSV, hoten.get(maSV));
        }
        System.out.println(">> Tong so sinh vien: " + hoten.size());

    }
    
}
