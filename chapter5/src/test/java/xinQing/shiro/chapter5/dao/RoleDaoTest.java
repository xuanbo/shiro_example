package xinQing.shiro.chapter5.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xinQing.shiro.chapter5.dao.impl.JdbcRoleDaoImpl;
import xinQing.shiro.chapter5.entity.Role;

import java.sql.SQLException;

/**
 * 测试RoleDao
 *
 * Created by xuan on 16-11-21.
 */
public class RoleDaoTest {

    private RoleDao roleDao;

    @Before
    public void init() {
        roleDao = new JdbcRoleDaoImpl();
    }

    @Test
    public void getById() throws SQLException {
        Role role = roleDao.getById(1);
        Assert.assertEquals("admin", role.getName());
    }

}
