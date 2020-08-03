package demo;

/*
day la lop generic mo ta 1 san pham, bao gom 
- thuoc tinh: ? maso, string ten, int dongia
- phuong thuc: xuat()
 */

public class Product<T> {
    public T id;
    public String name;
    public int price;
    
    public void output(){
        System.out.println("Thong tin san pham: ");
        System.out.println(" - ma so : "+ id);
        System.out.println(" - ten : " + name);
        System.out.println(" - don gia : " + price);
    }   
}

