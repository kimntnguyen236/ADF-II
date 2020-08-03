/*
Lớp phụ trách việc tương tác giữa bảng [tbCourse] trong CSDL sem2_demo
và đối tượng [Student] trong ứng dụng java
 */
package data;
import java.util.*;
import java.sql.*;
public class CourseDAO {
    // 1. Hàm lấy hết dữ liệu của bảng tbCourse -> arrayList
    public static List<Course> getList() {
        List<Course> dsC = new ArrayList<>();
        Course C =null;
        // 1. Tạo kết nối với CSDL sem2_demo
        Connection cn = MyLIB.getConnect();
        try {
            // 2. Tạo lệnh sql để gọi đến sql server
            String s = "select * from tbCourse;";
            Statement sta = cn.createStatement();
            // 3. Thi hành lệnh
            ResultSet rs = sta.executeQuery(s);
            
            // 4. Đọc hết các dòng trong rs -> đưa vô arrayList
            while (rs.next()) {                
                C = new Course();
                // Đọc từng cột trong dòng và gắn vô các thuộc tính tương ứng của C
                C.course_id=rs.getString(1);
                C.course_name=rs.getString(2);
                // 6. Đưa đối tượng C vô trong arrayList dsC
                dsC.add(C);
            }
            
            // đóng resources
            sta.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return dsC;
    }
}
