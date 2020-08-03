/*
 - Lớp này được viết để kiểm thử lớp MyException
 */
package demo;

import basic.MyException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestMyException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Nhap vao 1 so lon hon 0: ");
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n < 0) {
                    try {
                        throw new MyException("Nhap sai roi, nhap so >0 moi dung");
                    } catch (MyException ex) {
                        System.out.println("Loi: " + ex.getMessage());
                    }
                }
                break; // nhap đúng -> thoát vòng lặp while
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        } // kết thúc while
        System.out.println("FINISHED !!!");
    }

}
