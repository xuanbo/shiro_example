package xinQing.shiro.chapter5.dao.impl;

import xinQing.shiro.chapter5.dao.UserDao;
import xinQing.shiro.chapter5.entity.User;
import xinQing.shiro.chapter5.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDao的jdbc实现
 *
 * Created by xuan on 16-11-19.
 */
public class JdbcUserDaoImpl implements UserDao {

    @Override
    public User getByUsername(String username) throws SQLException {
        String sql = "select * from user where username = ?";
        // 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 创建PreparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置参数
        preparedStatement.setString(1, username);
        // 执行查询
        ResultSet resultSet = preparedStatement.executeQuery();
        // 遍历ResultSet，把参数封装到User对象中
        User user = new User();
        while (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setRoleId(resultSet.getInt("role_id"));
        }
        // 关闭资源
        DBUtil.close(resultSet, preparedStatement, connection);
        return user;
    }

}
