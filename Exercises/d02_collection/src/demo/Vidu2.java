/*
Bài tập minh họa về tập hợp cài đặt cấu trúc List : ArrayList, LinkedList, Vector 
 */
package demo;
import static demo.Vidu3.ds;
import java.util.*;
public class Vidu2 {
    static String[] ds = {
        "Quynh Luong", "Huy Nguyen", "Buu Loi", "Kim Nguyen", "Dung Ngo","Huyen Nguyen","An Le","Hoa Nguyen","Trung Nguyen","Vuong Ta", "Kien Nguyen"
    };
    public static void main(String[] args) {
        demoArrayList();
        demoLinkedList();
        demoVector();
    }
    static void demoArrayList(){
        List<String> hoten = Arrays.asList(ds);
        //in ra danh sách tên sv
        System.out.println("\n >>>> Danh sach ten [ARRAY]");
        for (String item : hoten) {
            System.out.printf("\t %s \n ",item);
        }
        
    }
    
    static void demoLinkedList(){
        List<String> hoten = new LinkedList<>(Arrays.asList(ds));
        //in ra danh sách tên sv
        System.out.println("\n >>>> Danh sach ten [LINKED LIST]"); // list cho phép nhập trùng
        for (String item : hoten) {
            System.out.printf("\t %s \n ",item);
        }
    }
    
    static void demoVector(){
        List<String> hoten = new Vector(Arrays.asList(ds));
        //in ra danh sách tên sv
        System.out.println("\n >>>> Danh sach ten [LINKED LIST]");
        for (String item : hoten) {
            System.out.printf("\t %s \n ",item);
        }
    }
}
