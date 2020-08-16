package com.app.demo.utils;


import com.app.demo.beans.FoodBean;
import com.app.demo.beans.HotelBean;
import com.app.demo.beans.ScenicBean;
import com.app.demo.beans.UserBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * 远程数据库管理类
 */
public class DataBaseUtil {

    private static final String IP = "cdb-kpgrklz8.cd.tencentcdb.com";//数据库IP
    private static final int PORT = 10103;//数据库端口
    private static final String USER = "root";//数据库用户名
    private static final String PWD = "cl199823";//数据库密码
    private static final String DB = "demo";//数据库名

    //建立数据库连接
    private static Connection getSQLConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 引用代码此处需要修改，IP为数据IP，PORT为端口号，DB为数据库名称，USER为数据库登录账户，PWD为数据库登录密码
            con = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PORT + "/"
                    + DB + "?characterEncoding=UTF-8", USER, PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;

    }


    //登录
    public static UserBean login(String phone, String password) {

        UserBean user = null;

        try {
            Connection conn = getSQLConnection();
            String sql = "SELECT * FROM user where phone = '" + phone + "' and password = '" + password + "'";
            Statement stmt = conn.createStatement();//
            ResultSet rs = stmt.executeQuery(sql);

            user = (UserBean) new ResultSet2BeanUtils().getObj(UserBean.class, rs);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }


    //注册
    public static int register(UserBean user) {

        int flag;

        try {
            Connection conn = getSQLConnection();
            String sql = "INSERT INTO user (phone,password,name) VALUES("
                    + "'" + user.getPhone() + "',"
                    + "'" + user.getPassword() + "',"
                    + "'" + user.getName() + "'"
                    + ")";

            Statement stmt = conn.createStatement();//

            ResultSet rs = stmt.executeQuery("select * from user where phone = '" + user.getPhone() + "'");
            if (rs.next()) {
                flag = 0;
            } else {
                int row = stmt.executeUpdate(sql);
                if (row > 0) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            flag = -1;
        }

        return flag;

    }

    //修改密码
    public static int updatePassword(int id, String oldPwd, String newPwd) {


        int flag;

        try {
            Connection conn = getSQLConnection();
            String sql = "UPDATE user SET password= '" + newPwd + "' WHERE id = " + id;

            Statement stmt = conn.createStatement();//

            System.out.println("select * from user where password = '" + oldPwd + "' and id = " + id);

            ResultSet rs = stmt.executeQuery("select * from user where password = '" + oldPwd + "' and id = " + id);

            if (rs.next()) {

                int row = stmt.executeUpdate(sql);

                if (row > 0) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            } else {

                flag = 0;
            }


            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            flag = -1;
        }

        return flag;
    }

    //修改个人信息
    public static boolean updateUser(int id, String name) {


        boolean flag = false;

        try {
            Connection conn = getSQLConnection();
            String sql = "UPDATE user SET name= '" + name + "' WHERE id = " + id;

            Statement stmt = conn.createStatement();//
            int row = stmt.executeUpdate(sql);


            if (row > 0) {
                flag = true;
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    //获取酒店数据
    public static List<HotelBean> getAllHotel() {

        List<HotelBean> lst = null;

        try {
            Connection conn = getSQLConnection();
            String sql = "SELECT * FROM hotel ORDER BY id ASC";

            Statement stmt = conn.createStatement();//
            ResultSet rs = stmt.executeQuery(sql);

            lst = new ResultSet2BeanUtils().getList(HotelBean.class, rs);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    //搜索酒店数据
    public static List<HotelBean> searchHotel(String where) {

        List<HotelBean> lst = null;

        String sql = "select * from hotel where 1=1 " + where;

        try {
            Connection conn = getSQLConnection();

            Statement stmt = conn.createStatement();//
            ResultSet rs = stmt.executeQuery(sql);

            lst = new ResultSet2BeanUtils().getList(HotelBean.class, rs);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    //获取美食数据
    public static List<FoodBean> getAllFood() {

        List<FoodBean> lst = null;

        try {
            Connection conn = getSQLConnection();
            String sql = "SELECT * FROM food ORDER BY id ASC";

            Statement stmt = conn.createStatement();//
            ResultSet rs = stmt.executeQuery(sql);

            lst = new ResultSet2BeanUtils().getList(FoodBean.class, rs);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    //搜索美食数据
    public static List<FoodBean> searchFood(String where) {

        List<FoodBean> lst = null;

        String sql = "select * from food where 1=1 " + where;

        try {
            Connection conn = getSQLConnection();

            Statement stmt = conn.createStatement();//
            ResultSet rs = stmt.executeQuery(sql);

            lst = new ResultSet2BeanUtils().getList(FoodBean.class, rs);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    //获取景点数据
    public static List<ScenicBean> getAllScenic() {

        List<ScenicBean> lst = null;

        try {
            Connection conn = getSQLConnection();
            String sql = "SELECT * FROM scenic ORDER BY id ASC";

            Statement stmt = conn.createStatement();//
            ResultSet rs = stmt.executeQuery(sql);

            lst = new ResultSet2BeanUtils().getList(ScenicBean.class, rs);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    //搜索景点数据
    public static List<ScenicBean> searchScenic(String where) {

        List<ScenicBean> lst = null;

        String sql = "select * from scenic where 1=1 " + where;

        try {
            Connection conn = getSQLConnection();

            Statement stmt = conn.createStatement();//
            ResultSet rs = stmt.executeQuery(sql);

            lst = new ResultSet2BeanUtils().getList(ScenicBean.class, rs);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }


}

