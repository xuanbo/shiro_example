package xinQing.shiro.chapter5.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接数据库
 *
 * Created by xuan on 16-11-19.
 */
public class DBUtil {

    /*-----------------------------------------------------------------
     *  定义常量 开始
     *-----------------------------------------------------------------*/

    // 数据库连接url
    private static final String URL = "jdbc:mysql://localhost:3306/shiro";

    // 数据库连接用户名
    private static final String USER = "root";

    // 数据库连接密码
    private static final String PASSWORD = "123456";

    /*-----------------------------------------------------------------
     *  定义常量 结束
     *-----------------------------------------------------------------*/

    /**
     * 获取数据库连接
     * 并没有采取数据源及orm框架，仅仅是为了使用jdbc获取Shiro的Realm
     *
     * @return Connection
     * @throws SQLException SQLException
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * 关闭连接
     *
     * @param autoCloseables AutoCloseable...
     */
    public static void close(AutoCloseable... autoCloseables) {
        for (AutoCloseable closeable : autoCloseables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
