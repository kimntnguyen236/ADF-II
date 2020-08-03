/*
Tạo class Doctor, hiện thực giao diện Serializable (implements Serializable) bao gồm :
    a. Các fields dữ liệu:
        i. String id, name, specialization
        ii. int availHours
    b. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
    c. Override method public String toString()
 */
package app;

import java.io.*;

public class Doctor implements Serializable{
    public String id,name,specialization;
    public int availHours;

    public Doctor() {
    }

    public Doctor(String id, String name, String specialization, int availHours) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availHours = availHours;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d",id,name,specialization,availHours);
    }
//    
//    public static void main(String[] args) {
//        Doctor d1 = new Doctor();
//        System.out.println("d1: "+d1);
//        
//        Doctor d2 = new Doctor("D02", "Trung", "Thuc quan", 4);
//        System.out.println("d2: "+d2);
//    }
}
