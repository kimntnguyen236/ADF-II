/*
Tạo class Product, mô tả 1 sản phẩm:
a. Fields: id, name, price, qoh
• NAME varchar(50) not null
• PRICE int (1 - 1000) not null
• QOH int (>0)
b. Methods: input() , toString()
 */
package data;

import java.util.*;

public class Product {

    public String name;
    public int id, price, qoh;

    public void input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(" nhap ten san pham: ");
            name = sc.nextLine().trim();
            if(name.length()>0){
                break;
            }
        }

        while(true){
            try {
                System.out.print(" nhap don gia [1-1000]:");
                price = Integer.parseInt(sc.nextLine().trim());
                if(price>=1 && price<=1000){
                    break;
                }
            } catch (Exception e) {
                System.out.println("Loi: "+ e.getMessage());
            }
        }
        
        while(true){
            try {
                System.out.print(" nhap so luong ton kho [>0]:");
                qoh = Integer.parseInt(sc.nextLine().trim());
                if(qoh>0){
                    break;
                }
            } catch (Exception e) {
                System.out.println("Loi: "+ e.getMessage());
            }
        }
        
    }

    @Override
    public String toString() {
        return String.format("%5d %-30s %5d %3d" , id, name, price, qoh);
    }
}
