/*
1. Các fields dữ liệu (mô tả cấu trúc bảng tbEmployee):
int id
String projectName, startDate
int value
boolean completed
2. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
3. Các method:
public void input()
public void String toString()
 */
package model;

import com.oracle.webservices.internal.api.databinding.DatabindingModeFeature;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Project {

    public String projectName, startDate;
    public int value, ID;
    public boolean completed;

    public Project() {
    }

    public Project(String projectName, String startDate, int value, int ID, boolean completed) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.value = value;
        this.ID = ID;
        this.completed = completed;
    }

    

    public void input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập tên project: ");
            projectName = sc.nextLine().trim();
            if (projectName.length() > 0) {
                break;
            }
            System.out.println("Tên project không được để trống ! ");
        }
        while (true) {
            System.out.print("Nhập ngày bắt đầu [yyyy-mm-dd]: ");
            startDate = sc.nextLine().trim();
            if (Pattern.matches("\\d{4}-\\d{2}-\\d{2}", startDate)) {
                break;
            }
            System.out.println("Nhập sai định dạng. Vui lòng nhập lại ! ");
        }
        while (true) {            
            System.out.print("Nhập value: ");
            value = Integer.parseInt(sc.nextLine().trim());
            if (value > 0) {
                break;
            }
            System.out.println("Value >0 ");
        }
        while (true) {            
            System.out.print("Complete: ");
        completed = sc.nextBoolean();
        String s = String.valueOf(completed);
            if (s.length()>0) {
                break;
            }
            System.out.println("Vui lòng nhập tiến độ ! ");
        }
        
    }

    @Override
    public String toString() {
        return String.format("%d - %s - %s - %d - %s",ID, projectName, startDate, value, completed);
    }

}
