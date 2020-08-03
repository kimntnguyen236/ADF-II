/*
- B1: Đây là lớp thư viện để: nạp và đăng kí driver SQL JDBC 
- B2: Kết nối đến cơ sở dữ liệu [sem2_demo] để truy cập các bảng trong cơ sở dữ liệu đó
 */
package model;

// tất cả thao tác liên quan đến CSDL đều được xây dựng trong gói [sql]
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLib {
    // phương thức nạp driver JDBC và kết nối đến CSDL [sem2_demo]
    public static java.sql.Connection getConnect(){
        // tạo collection
        Connection cn=null; // nằm trong gói java.sql
        try {
            // 1.nạp và đăng kí driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // cổng để nói chuyện với ứng dụng bên ngoài là 1433
            // 2. Mở kết nối đến SQL Server [localhost:1433], cụ thể là sẽ làm việc với DB [sem2_demo]
            String url = "jdbc:sqlserver://localhost:1433; database = sem2_demo";
            cn = DriverManager.getConnection(url,"sa", "123"); // url, tài khoản, mật mã
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    }
}
