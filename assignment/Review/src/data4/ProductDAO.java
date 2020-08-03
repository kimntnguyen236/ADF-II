/*
- Lớp cầu nối giữa class [Product] của ứng dụng Java và bảng [tbProduct] trong CSDL [sem2_demo]
- Xem, thêm, xóa, sửa dữ liệu (select, insert, delete, update SQL) getList <-> select
 */
package data4;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProductDAO {
    public static List<Product4> getList(){
        List<Product4> ds = new ArrayList<>();
        
        // 1. tạo kết nối
        Connection cn = MyLIB.getConnect();
        
        
        try {
            // 2. Tạo đối tượng chứa lệnh select SQL
        String sql = "select * from tbProduct";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            // 3. Cho thực hiện lệnh select SQL
            ResultSet rs = pst.executeQuery(); // select -> Query . Insert, delete, update -> Update
            
            // 4. Đọc các dòng dữ liệu trong rs => ds 
            Product4 p = null; // new Product4(); -> không được
            while (rs.next()) {   
                p = new Product4();
                p.id=rs.getString(1);
                p.name=rs.getString(2);
                p.price=rs.getInt(3);
                
                // đưa đối tượng p vô ds
                ds.add(p);
            }
            // đóng resources
            pst.close();
            cn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
    
    // hàm thêm 1 sp [Product] vô bảng [tbProduct]
    public static int insert(Product4 p){
        int n = 0;
        // 1. tạo kết nối
        Connection cn = MyLIB.getConnect();
        
        try {
            // 2. Tạo đối tượng chứa lệnh insert SQL
        String sql = "insert tbProduct values(?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            // 3. Gắn gtri (thuộc tính của đối tượng) cho các tham số ?
            pst.setString(1, p.id);
            pst.setString(2, p.name);
            pst.setInt(3, p.price);
            
            // 4. Cho thực hiện lệnh insert SQL
            n = pst.executeUpdate(); // select -> Query . Insert, delete, update -> Update
            
            // 5. Đóng resources
            pst.close();
            cn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    //ham xoa 1 san pham p [Product] trong bang [tbProduct] dua vao ma so cua san pham
    public static int delete(String maSP){
        int n = 0;
        
        //1. tao ket noi
        Connection cn = MyLIB.getConnect();        
        try {
            //2. tao doi tuong chua linh delete SQL
            String sql = "delete from tbProduct where productID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            //3. gan gia tri cho cac tham so ?
            pst.setString(1, maSP);
            
            //4. cho thuc hien linh delete SQL
            n = pst.executeUpdate();
                    
            //5. dong resource
            pst.close();
            cn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return n;
    }
}
