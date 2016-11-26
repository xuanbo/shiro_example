package xinQing.shiro.chapter5.dao.impl;

import xinQing.shiro.chapter5.dao.RoleDao;
import xinQing.shiro.chapter5.entity.Role;
import xinQing.shiro.chapter5.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RoleDao的jdbc实现
 *
 * Created by xuan on 16-11-21.
 */
public class JdbcRoleDaoImpl implements RoleDao {

    @Override
    public Role getById(Integer id) throws SQLException {
        String sql = "select * from role where id = ?";
        // 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 创建PreparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置参数
        preparedStatement.setInt(1, id);
        // 执行查询
        ResultSet resultSet = preparedStatement.executeQuery();
        // 遍历ResultSet，把参数封装到Role对象中
        Role role = new Role();
        while (resultSet.next()) {
            role.setId(resultSet.getInt("id"));
            role.setName(resultSet.getString("name"));
            role.setDescription(resultSet.getString("description"));
        }
        // 关闭资源
        DBUtil.close(resultSet, preparedStatement, connection);
        return role;
    }

}
