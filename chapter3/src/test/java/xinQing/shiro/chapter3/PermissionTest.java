package xinQing.shiro.chapter3;

import org.apache.shiro.subject.Subject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试用户权限
 *
 * Created by xuan on 16-11-17.
 */
public class PermissionTest {

    private Subject subject;

    @Before
    public void login() {
        subject = ShiroUtil.login("shiro-permission.ini", "wang", "123456");
    }

    @After
    public void logout() {
        subject.logout();
    }

    /**
     * isPermitted
     * 拥有权限返回true
     */
    @Test
    public void isPermitted() {
        System.out.println(subject.isPermitted("user:create"));
        boolean[] subjectPermitted = subject.isPermitted("user:select", "user:update", "user:insert", "user:delete");
        for (boolean permitted : subjectPermitted) {
            System.out.println(permitted);
        }
    }

    /**
     * isPermitted
     * 用户都拥有给定的权限集合才返回true
     */
    @Test
    public void isPermittedAll() {
        System.out.println(subject.isPermittedAll("user:select", "user:update", "user:insert"));
        System.out.println(subject.isPermittedAll("user:select", "user:update", "user:insert", "user:delete"));
        System.out.println(subject.isPermittedAll("user:select", "user:update", "user:insert", "user:delete", "user:getByPage"));
    }

    /**
     * 检查用户是否拥有权限，没有则抛出UnauthorizedException异常
     */
    @Test
    public void checkPermission() {
        subject.checkPermission("user:select");
    }

    /**
     * 检查用户是否拥有所有给定的权限，没有则抛出UnauthorizedException异常
     */
    @Test
    public void checkPermissions() {
        subject.checkPermissions("user:select", "user:update");
    }
}
