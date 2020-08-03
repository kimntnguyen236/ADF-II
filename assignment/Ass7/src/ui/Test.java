package ui;

import model.*;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        String op = "";
        Scanner sc = new Scanner(System.in);

        Test o = new Test();
        
        while (true) {
            System.out.println("\n ==== MENU ====");
            System.out.println("1. Thêm dự án mới");
            System.out.println("2. Xóa đối tượng dự án theo ID");
            System.out.println("3. In danh sách dự án");
            System.out.println("4. In danh sách dự án đã hoàn tất");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng [1-5]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1": o.add();
                    break;
                case "4": o.deleteComplete();
                    break;
                case "2": o.delete();
                    break;
                case "3": o.display();
                    break;
                case "5":
                    return;
            } }

    }

    private void add() {
        Project p = new Project();
        p.input();
        
        ProjectDAO.Insert(p);
    }

    private void display() {
        System.out.println("\n DANH SACH DỰ ÁN");
       ProjectDAO.getList().stream().forEach(System.out::println);
    }

    private void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã số dự án muốn xóa: ");
        String id = sc.nextLine().trim();
        ProjectDAO.Delete(id);
        System.out.println(">>>> Đã xóa thành công");
    }

    private void deleteComplete() {
        List<Project> ds = new ArrayList<>();
        ds = ProjectDAO.getList();
        ds.stream().filter(item->item.completed==true).forEach(System.out::println);
        long count = ds.stream().filter(item->item.completed==true).count();
        if(count ==0){
            System.out.println(" >>> Ko tim thay dự án đã hoàn thành !!!! ");
        }
    }
}

     
