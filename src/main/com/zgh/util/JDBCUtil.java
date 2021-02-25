package main.com.zgh.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/book_shopping?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    private static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try {
                //1.加载驱动程序
                Class.forName("com.mysql.cj.jdbc.Driver");
                //2. 获得数据库连接
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return conn;
    }
}
