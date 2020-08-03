/*
In ra toan bo danh sach cac lop hoc trong bang [tbBatch] cua CSDL [sem2_demo]
 */
package demo;

import data.*;
import java.util.*;
public class Vidu1 {

    public static void main(String[] args) {
        List<Batch> dsLop = BatchDAO.getList();
        System.out.println(">>>> DANH SÁCH LỚP");
        for (Batch item : dsLop) {
            System.out.println(item);
        }
            System.out.println("\n");
            
        
        List<Student> dsStudents = StudentDAO.getList();
        System.out.println(">>>> DANH SÁCH SINH VIÊN");
        for (Student item : dsStudents) {
            System.out.println(item);
        }
            System.out.println("\n");
        
        
        List<Course> dsC = CourseDAO.getList();
        System.out.println(">>>> DANH SÁCH KHÓA HỌC");
        for (Course course : dsC) {
            System.out.println(course);
        }
            System.out.println("\n");
            
            
        List<User> dsU = UserDAO.getList();
        System.out.println(">>>> DANH SÁCH NGƯỜI DÙNG");
        for (User user : dsU) {
            System.out.println(user);
        }
    }
    
}

