/*
Lớp phụ trách việc tương tác giữa bảng [tbStudent] trong CSDL sem2_demo
và đối tượng [Student] trong ứng dụng java
 */
package data;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    // 1. Hàm lấy hết dữ liệu của bảng tbStudent -> arraylist
    public static List<Student> getList() {
        List<Student> dsSt = new ArrayList<>();
        Student St = null;
        // 1. Tạo kết nối với CSDL sem2_demo
        Connection cn = MyLIB.getConnect();
        try {
            // 2. Tạo lệnh sql để gọi đến sql server
            String s = "select * from tbStudent;";
            Statement sta = cn.createStatement();
            // 3. thi hành lệnh
            ResultSet rs = sta.executeQuery(s);

            // 4. Đọc hết các dòng trong rs -> đưa vô arraylist
            while (rs.next()) {
                St = new Student();
                // Đọc từng cột trong dòng và gắn vô các thuộc tính tương ứng của St
                St.st_id=rs.getString(1);
                St.firstName=rs.getString(2);
                St.lastName=rs.getString(3);
                St.gender=rs.getBoolean(4);
                St.phone=rs.getInt(5);
                St.batchNo=rs.getString(6);
                // 6. Đưa đối tượng St vô trong arrayList dsSt
                dsSt.add(St);
            }
            // đóng resources
            sta.close();
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dsSt;
    }
}
