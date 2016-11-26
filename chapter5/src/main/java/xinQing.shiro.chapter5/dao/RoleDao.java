package xinQing.shiro.chapter5.dao;

import xinQing.shiro.chapter5.entity.Role;

import java.sql.SQLException;

/**
 * RoleDao
 *
 * Created by xuan on 16-11-21.
 */
public interface RoleDao {

    /**
     * 根据id查询角色
     *
     * @param id 角色id
     * @return Role
     * @throws SQLException SQLException
     */
    Role getById(Integer id) throws SQLException;

}
