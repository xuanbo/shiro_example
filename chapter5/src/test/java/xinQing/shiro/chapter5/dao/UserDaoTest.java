package xinQing.shiro.chapter5.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xinQing.shiro.chapter5.dao.impl.JdbcUserDaoImpl;
import xinQing.shiro.chapter5.entity.User;

/**
 * 测试UserDao
 *
 * Created by xuan on 16-11-19.
 */
public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void init() {
        userDao = new JdbcUserDaoImpl();
    }

    @Test
    public void getByUsername() throws Exception {
        User user = userDao.getByUsername("wang");
        Assert.assertEquals("123456", user.getPassword());
    }

}
