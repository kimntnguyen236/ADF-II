/*
    ii. Tạo class Employee, bao gồm :
        1. Các fields dữ liệu (mô tả cấu trúc bảng tbNhanVien):
            String id, fullname
            boolean gender
            int salary
        2. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
        3. Các method:
            public void input()
            public void String toString()
 */
package model;

import java.util.Scanner;


public class Employee{
    public String id,name;
    public boolean gender;
    public int salary;

    public Employee() {
    }

    public Employee(String id, String name, boolean gender, int salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }
    
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println(">>Nhập dữ liệu Employee<<");
        while(true){
            System.out.println("ID : ");
            id=sc.nextLine().trim();
            if(id.length()<=5 &&id.length()>0) break;
            System.out.println("ID chỉ có tối đa 5 ký tự");
        }
        
        while(true){
            System.out.println("Name : ");
            name=sc.nextLine().trim();
            if(name.length()<=30 &&name.length()>0) break;
            System.out.println("Name chỉ có tối đa 30 ký tự");
        }
        
        while(true){
            String gioitinh;
            System.out.println("Gender [M/F]:");
            gioitinh=sc.nextLine().trim().toUpperCase();
            if(gioitinh.equals("M")){
                gender=true;
                break;
            }
            if(gioitinh.equals("F")){
                gender=false;
                break;
            }
            System.out.println("Gender phải có định dạng 'M' hoặc 'F' ");
        }
        
        while(true){
            System.out.println("Salary [100-10000]:");
            salary=Integer.parseInt(sc.nextLine().trim());
            if(salary>=100&&salary<=10000) break;
            System.out.println("Salary phải nằm trong khoảng [100-10000]");
        }
    }

    @Override
    public String toString() {
        return String.format("ID : %s - Name : %s - Gender : %s - Salary : %d",id,name,gender?"Male":"Female",salary);
    }
    
}