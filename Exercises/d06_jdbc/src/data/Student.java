/*
Mô tả cấu trúc cả bảng tbStudent trong CSDL sem2_demo
 */
package data;

import java.util.Scanner;

public class Student extends Batch {

    public String st_id, firstName, lastName;
    public boolean gender;
    public int phone;

    public Student() {
    }

    public Student(String st_id, String firstName, String lastName, boolean gender, int phone, String batchNo, String desc, int fee) {
        super(batchNo, desc, fee);
        this.st_id = st_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã Student: ");
        st_id = sc.nextLine().trim();
        System.out.print("Nhập tên: ");
        firstName = sc.nextLine().trim();
        System.out.print("Nhập họ: ");
        lastName = sc.nextLine().trim();
        System.out.print("Nhập giới tính [true/false]: ");
        gender = sc.nextBoolean();
        System.out.print("Nhập số điện thoại: ");
        phone = Integer.parseInt(sc.nextLine().trim());

    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s - %d",st_id,firstName,lastName,gender,phone);
    }
    
    

}
