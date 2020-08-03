/*
 Dduocj viết ra đẻ kiểm thủ các hình thức Generic của product
 */
package demo;

/**
 *
 * @author LENOVO
 */
public class TestProduct {

    public static void main(String[] args) {
        // Tạo ra một đối tượng sản phẩm
        Product p1 = new Product();
        p1.id = 100;
        p1.name = "laptop";
        p1.price = 200;
        // Tạo một đối tượng SP-Generic
        Product<String> p2 = new Product<>();
        p2.id = "100";
        p2.name = "Smart phone";
        p2.price = 400;
        System.out.println("Sản phẩm thứ 1:");
        p1.output();
        System.out.println("Sản phẩm thứ 2:");
        p2.output();

    }

}
