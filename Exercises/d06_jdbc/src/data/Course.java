/*
Mô tả cấu trúc bảng tbCourse trong CSDL sem2_demo
 */
package data;

import java.util.Scanner;

public class Course {
    public String course_id,course_name;

    public Course() {
    }

    public Course(String course_id, String course_name) {
        this.course_id = course_id;
        this.course_name = course_name;
    }
    
    public void input(){
        Scanner sc =new Scanner(System.in);
        System.out.print("Nhập mã khóa học: ");
        course_id = sc.nextLine().trim();
        System.out.print("Nhập tên khóa học: ");
        course_name = sc.nextLine().trim();
    }

    @Override
    public String toString() {
        return String.format("%s - %s",course_id,course_name);
    }
    
    
}
