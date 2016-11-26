package xinQing.shiro.chapter5.dao;

import xinQing.shiro.chapter5.entity.User;

import java.sql.SQLException;

/**
 * UserDao
 *
 * Created by xuan on 16-11-19.
 */
public interface UserDao {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 根据用户名查询的用户
     * @throws SQLException SQLException
     */
    User getByUsername(String username) throws SQLException;

}
