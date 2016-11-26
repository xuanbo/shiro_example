package xinQing.shiro.chapter5.dao;

import xinQing.shiro.chapter5.entity.Permission;

import java.sql.SQLException;
import java.util.List;

/**
 * PermissionDao
 *
 * Created by xuan on 16-11-21.
 */
public interface PermissionDao {

    /**
     * 根据角色id获取权限
     *
     * @param roleId 角色id
     * @return List<Permission>
     * @throws SQLException SQLException
     */
    List<Permission> getByRoleId(Integer roleId) throws SQLException;

}
