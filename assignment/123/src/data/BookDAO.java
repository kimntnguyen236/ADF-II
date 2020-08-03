package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    
    public static int Insert(Book newBook) {
        int r = -1;
        Connection cn = MyLIB.getConnect();

        try {
            String s = "Insert Book values(?,?,?)";
            PreparedStatement pre = cn.prepareStatement(s);
            pre.setString(1, newBook.Title);
            pre.setString(2, newBook.Author);
            pre.setInt(3, newBook.Edition);

            r = pre.executeUpdate();
            pre.close();
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return r;
    }
    
     public static int Delete(String pID) {
        int r = -1;
        Connection cn = MyLIB.getConnect();

        try {
            String s = "delete from Book where BookId = ?";
            PreparedStatement pre = cn.prepareStatement(s);

            pre.setString(1, pID);

            r = pre.executeUpdate();

            pre.close();
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return r;
    }
     
     public static List<Book> getList(){
        List<Book> ds=new ArrayList<>();
        Connection cn=MyLIB.getConnect();
        
        try{
            String sql="select * from Book";
            PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            Book p=null;
            while(rs.next()){
               p=new Book();
               p.BookId=rs.getInt(1);
               p.Title=rs.getString(2);
               p.Author=rs.getString(3);
               p.Edition=rs.getInt(4);
               ds.add(p);

            }
            pst.close();
            cn.close();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return ds;
    }
}
