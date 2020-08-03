
package data;

// tất cả thao tác liên quan đến CSDL đều được xây dựng trong gói [sql]
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLIB {
    // phương thức nạp driver JDBC và kết nối đến CSDL
    public static java.sql.Connection getConnect(){
        // tạo collection
        Connection cn=null; // nằm trong gói java.sql
        try {
            // 1.nạp và đăng kí driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // cổng để nói chuyện với ứng dụng bên ngoài là 1433
            // 2. Mở kết nối đến SQL Server [localhost:1433], cụ thể là sẽ làm việc với DB 
            String url = "jdbc:sqlserver://localhost:1433; database = LibraryDB";
            cn = DriverManager.getConnection(url,"sa", "123"); // url, tài khoản, mật mã
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    }
}
