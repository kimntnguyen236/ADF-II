
package data2;

public class Product2 {
    public String id, name;
    public int price;

    @Override
    public String toString() {
        return String.format("%s, %s, %d ", id, name, price);
    }

    // kiểm tra nội dung
    @Override
    public boolean equals(Object o) {
        Product2 p = (Product2) o;
        return this.id.equals(p.id);
    }
    
   // => Trùng nhau : trùng về mặt nội dung và bộ nhớ
    
    // kiểm tra bộ nhớ
    @Override
    public int hashCode() {
        return 100;
    }
    
}
