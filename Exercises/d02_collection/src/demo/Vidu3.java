/*
Demo về các tập hợp cài đặt cấu trức SET : HashSet, LinkedHashSet, TreeSet
 */
package demo;
import static demo.Vidu2.ds;
import java.util.*;
public class Vidu3 {
    static String[] ds = {
        "Quynh Luong", "Huy Nguyen", "Buu Loi", "Kim Nguyen", "Dung Ngo","Huyen Nguyen","An Le","Hoa Nguyen","Trung Nguyen","Vuong Ta", "Kien Nguyen", "Quynh Luong"
    };
    public static void main(String[] args) {
        demoHashSet();
        demoLinkedHashSet();
        demoTreeSet();
    }
    
    static void demoHashSet(){
        Set<String> hoten = new HashSet<>(Arrays.asList(ds));
        //in ra danh sách tên sv
        System.out.println("\n >>>> Danh sach ten [HASH SET]");
        for (String item : hoten) {
            System.out.printf("\t %s \n ",item);
        }
    }
    static void demoLinkedHashSet(){ // không thay đổi vị trí giống như làm việc với List
        Set<String> hoten = new LinkedHashSet<>(Arrays.asList(ds));
        //in ra danh sách tên sv
        System.out.println("\n >>>> Danh sach ten [LINKED HASH SET]");
        for (String item : hoten) {
            System.out.printf("\t %s \n ",item);
        }
    }
    
    static void demoTreeSet(){ // không được đưa vào giá trị null
        Set<String> hoten = new TreeSet<>(Arrays.asList(ds));
        //in ra danh sách tên sv
        System.out.println("\n >>>> Danh sach ten [LINKED LIST]");
        for (String item : hoten) {
            System.out.printf("\t %s \n ",item);
        }
    }
}
