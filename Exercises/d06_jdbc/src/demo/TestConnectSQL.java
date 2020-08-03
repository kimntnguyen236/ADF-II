/*
- Kiểm tra kết nối đến CSDL SQLServer
 */
package demo;
import data.*;
import java.sql.*;
public class TestConnectSQL {

    public static void main(String[] args) {
        Connection cn = MyLIB.getConnect();
        if (cn != null) {
            System.out.println(">>>> Thanh cong");
        }
    }
    
}
