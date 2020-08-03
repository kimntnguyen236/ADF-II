/*
Xoa 1 lop học trong bảng [tbBatch] của CSDL [sem2_demo] theo ma so lop
 */
package demo;
import data.*;
import java.util.*;

public class Vidu3 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String maso ="";
        System.out.print("Nhập mã số lớp học muốn xóa: ");
        maso = sc.nextLine().trim();
        
        int n = BatchDAO.delete(maso);
        
        if (n>0) {
            System.out.println("Đã xóa lớp học có mã số: "+maso);
        } else {
            System.out.println("Việc xóa lớp học thất bại !!! ");
        }
    }
    
}
