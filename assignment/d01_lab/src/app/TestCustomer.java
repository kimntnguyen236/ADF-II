
package app;
import basic.*;
import java.awt.SystemColor;
import java.util.Scanner;
public class TestCustomer {

    public static void main(String[] args) {
        TestCustomer o = new TestCustomer();
        o.menu();
    }
    public void menu(){
        CustomerList c =new CustomerList();
        Scanner sc = new Scanner(System.in);
        String op = " ";
        while (true) {            
            System.out.println("=== MENU ===");
            System.out.println("1. Thêm KH ");
            System.out.println("2. In ds KH ");
            System.out.println("3. Tim KH theo tên");
            System.out.println("4. Exit");
            System.out.print("Chọn (1-4): ");
            op = sc.nextLine().trim();
            switch(op){
                case "1" : c.add();
                break;
                case "2" : c.displayAll();
                break;
                case "3" : 
                    System.out.print("Nhap ten KH muốn tìm kiếm : "); 
                    String search = sc.nextLine().trim();
                    c.searchByName(search); break;
                case "4" : return;
            }
        }
    }
}
