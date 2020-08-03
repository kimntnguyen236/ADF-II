/*
Lớp phụ  trách tương tác giữa bảng [tbUser] trong CSDL sem2_demo
và đối tượng [User] trong ứng dụng java
 */
package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    
    // 1. Hàm lấy hết dữ liệu của bảng tbStudent -> arraylist
    public static List<User> getList() {
        List<User> dsU = new ArrayList<>();
        User U = null;
        // 1. Tạo kết nối với CSDL sem2_demo
        Connection cn = MyLIB.getConnect();
        try {
            // 2. Tạo lệnh sql để gọi đến sql server
            String s = "select * from tbUser;";
            Statement sta = cn.createStatement();
            // 3. thi hành lệnh
            ResultSet rs = sta.executeQuery(s);

            // 4. Đọc hết các dòng trong rs -> đưa vô arraylist
            while (rs.next()) {
                U = new User();
                // Đọc từng cột trong dòng và gắn vô các thuộc tính tương ứng của St
                U.userid=rs.getString(1);
                U.pass=rs.getString(2);
                U.role = rs.getInt(3);
                // 6. Đưa đối tượng St vô trong arrayList dsSt
                dsU.add(U);
            }
            // đóng resources
            sta.close();
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dsU;
    }
}
