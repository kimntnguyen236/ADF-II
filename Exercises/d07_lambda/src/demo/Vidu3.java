/*
Build-in functional interface
 */
package demo;
import java.util.*;
import java.util.function.*;
public class Vidu3 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập số thứ 1: ");
        int a = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Nhập số thứ 2: ");
        int b = Integer.parseInt(sc.nextLine().trim());
        
        BiConsumer<Integer, Integer> f1 = (n1,n2)-> System.out.printf("%d + %d = %d \n", n1, n2, n1 + n2);
        BiConsumer<Integer, Integer> f2 = (n1,n2)->System.out.printf("%d - %d = %d \n", n1, n2, n1 - n2);
        
        // thuc hien bieu thuc f1, f2
        f1.accept(a, b);
        f2.accept(a, b);
        
    }
    
}
