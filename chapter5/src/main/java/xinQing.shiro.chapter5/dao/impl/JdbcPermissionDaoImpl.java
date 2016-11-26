package xinQing.shiro.chapter5.dao.impl;

import xinQing.shiro.chapter5.dao.PermissionDao;
import xinQing.shiro.chapter5.entity.Permission;
import xinQing.shiro.chapter5.entity.User;
import xinQing.shiro.chapter5.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * PermissionDao的jdbc实现
 *
 * Created by xuan on 16-11-21.
 */
public class JdbcPermissionDaoImpl implements PermissionDao {

    @Override
    public List<Permission> getByRoleId(Integer roleId) throws SQLException {
        String sql = "select * from permission where role_id = ?";
        // 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 创建PreparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置参数
        preparedStatement.setInt(1, roleId);
        // 执行查询
        ResultSet resultSet = preparedStatement.executeQuery();
        // 遍历ResultSet，把参数封装到User对象中
        List<Permission> permissions = new ArrayList<>();
        while (resultSet.next()) {
            Permission permission = new Permission();
            permission.setId(resultSet.getInt("id"));
            permission.setName(resultSet.getString("name"));
            permission.setDescription(resultSet.getString("description"));
            permission.setRoleId(resultSet.getInt("role_id"));
            permissions.add(permission);
        }
        // 关闭资源
        DBUtil.close(resultSet, preparedStatement, connection);
        return permissions;
    }

}
