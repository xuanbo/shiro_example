package xinQing.shiro.chapter2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * 测试登录登出
 *
 * Created by xuan on 16-11-16.
 */
public class LoginLogoutTest {

    /**
     * 配置文件写死用户名和密码
     */
    @Test
    public void helloWorld() {
        helloWorld("shiro.ini");
    }

    /**
     * 自定义Realm
     */
    @Test
    public void realm() {
        helloWorld("shiro-realm.ini");
    }

    /**
     * 测试多Realm
     * 会按照顺序寻找
     */
    @Test
    public void multiRealm() {
        helloWorld("shiro-multi-realm.ini");
    }

    /**
     * 用户信息使用数据库存储
     */
    @Test
    public void jdbcRealm() {
        helloWorld("shiro-jdbc-realm.ini");
    }

    /**
     * helloWorld
     *
     * @param iniPath 配置文件的路径
     */
    private void helloWorld(String iniPath) {
        // 1.获取SecurityManager工厂,此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:" + iniPath);

        // 2.得到SecurityManager实例,并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 3.得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("wang", "123");

        try {
            // 4.登录,即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            // 5.身份验证失败
            e.printStackTrace();
        }

        // 断言用户已经登录
        Assert.assertEquals(true, subject.isAuthenticated());

        // 6.退出
        subject.logout();
    }

    @After
    public void tearDown() throws Exception {
        // 退出时请解除绑定Subject到线程 否则对下次测试造成影响
        ThreadContext.unbindSubject();
    }
}
