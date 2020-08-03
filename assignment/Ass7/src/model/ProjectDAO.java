/*
1. public int insert (Project pro):
• thêm đối tượng dự án pro vô bảng tbProject
• trả về số nguyên dương nếu tác vụ thành công, ngược lại trả về giá
trị âm
2. public int delete (String pID):
• Xóa đối tượng dự án có mã số pID trong bảng tbProject
• trả về số nguyên dương nếu tác vụ thành công, ngược lại trả về giá
trị âm
3. public List<Project> getList() , trả về danh sách dự án trong bảng
tbProject.
4. public List<Project> getCompletedProject() , trả về danh sách dự án
đã hoàn tất (completed = true) trong bảng tbProject.
 */
package model;

import java.util.*;
import java.sql.*;

public class ProjectDAO {

    public static List<Project> getList() {
        List<Project> ds = new ArrayList<>();
        Project p = null;

        Connection cn = MyLib.getConnect();

        try {

            String s = "select * from tbProject";
            Statement sta = cn.createStatement();

            ResultSet rs = sta.executeQuery(s);
            while (rs.next()) {
                p = new Project();
                p.ID = rs.getInt(1);
                p.projectName = rs.getString(2);
                p.startDate = rs.getString(3);
                p.value = rs.getInt(4);
                p.completed = rs.getBoolean(5);
                ds.add(p);

            }
            sta.close();
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }

    public static int Insert(Project newProject) {
        int r = -1;
        Connection cn = MyLib.getConnect();

        try {
            String s = "Insert tbProject values(?,?,?,?)";
            PreparedStatement pre = cn.prepareStatement(s);
// vì ID là identity nên không thể nhập được
            pre.setString(1, newProject.projectName);
            pre.setString(2, newProject.startDate);
            pre.setInt(3, newProject.value);
            pre.setBoolean(4, newProject.completed);

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
        Connection cn = MyLib.getConnect();

        try {
            String s = "delete from tbProject where ID = ?";
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

    public static void DisplayCompleted() {
        int dem = 0;
        List<Project> ds = new ArrayList<>();
        ds = ProjectDAO.getList();
        for (Project d : ds) {
            if (d.completed == true) {
                System.out.println(d);
                dem++;
            }
        }
        System.out.printf("Co %d du an da hoan thanh !", dem);
    }
}
