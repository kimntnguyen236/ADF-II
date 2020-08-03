/*
Mô tả cấu trúc bảng tbUser trong CSDL sem2_demo
 */
package data;

import java.util.Scanner;

public class User {
    public String userid,pass;
    public int role;

    public User() {
    }

    public User(String userid, String pass, int role) {
        this.userid = userid;
        this.pass = pass;
        this.role = role;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập id người dùng: ");
        userid = sc.nextLine().trim();
        System.out.print("Nhập mật khẩu: ");
        pass = sc.nextLine().trim();
        System.out.print("Nhập vai trò: ");
        role = Integer.parseInt(sc.nextLine().trim());
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %d",userid,pass,role);
    }
    
    
}
