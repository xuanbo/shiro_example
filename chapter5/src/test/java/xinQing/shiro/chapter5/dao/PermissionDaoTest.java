package xinQing.shiro.chapter5.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xinQing.shiro.chapter5.dao.impl.JdbcPermissionDaoImpl;

import java.sql.SQLException;

/**
 * 测试PermissionDao
 *
 * Created by xuan on 16-11-21.
 */
public class PermissionDaoTest {

    private PermissionDao permissionDao;

    @Before
    public void init () {
        permissionDao = new JdbcPermissionDaoImpl();
    }

    @Test
    public void getByRoleId() throws SQLException {
        permissionDao.getByRoleId(1).forEach(System.out::println);
    }

}
