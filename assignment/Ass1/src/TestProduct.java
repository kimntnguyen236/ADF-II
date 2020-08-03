
import java.util.Scanner;


public class TestProduct {
public static void main(String[] args) {
        TestProduct o = new TestProduct();
        o.menu();
    }
    public void menu(){
        ProductList c =new ProductList();
        Scanner sc = new Scanner(System.in);
        String op = " ";
        while (true) {            
            System.out.println("=== MENU ===");
            System.out.println("1. Thêm sản phẩm ");
            System.out.println("2. In ds sản phẩm ");
            System.out.println("3. Tim sản phẩm theo tên");
            System.out.println("4. Exit");
            System.out.print("Chọn (1-4): ");
            op = sc.nextLine().trim();
            switch(op){
                case "1" : c.addProduct();
                break;
                case "2" : c.displayALl();
                break;
                case "3" : 
                    System.out.print("Nhap ten sản phẩm muốn tìm kiếm : "); String search = sc.nextLine().trim();
                    c.searchByName(search); break;
                case "4" : return;
                default:
                    System.out.println("Xin vui lòng nhập lại lựa chọn [1-4]");
            }
        }
    }
    
}
