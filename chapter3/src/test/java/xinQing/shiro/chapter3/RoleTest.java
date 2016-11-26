package xinQing.shiro.chapter3;

import org.apache.shiro.subject.Subject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * 测试用户角色
 *
 * Created by xuan on 16-11-17.
 */
public class RoleTest {

    private Subject subject;

    @Before
    public void login() {
        subject = ShiroUtil.login("shiro-role.ini", "wang", "123456");
    }

    @After
    public void logout() {
        subject.logout();
    }

    /**
     * hasRole
     * 拥有该角色则返回true
     */
    @Test
    public void hasRole() {
        System.out.println(subject.hasRole("role1"));
    }

    /**
     * hasRoles
     * 返回数组，分别对应是否拥有角色
     */
    @Test
    public void hasRoles() {
        boolean[] hasRoles = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
        for (boolean hasRole : hasRoles) {
            System.out.println(hasRole);
        }
    }

    /**
     * hasAllRoles
     * 拥有所有角色才返回true
     */
    @Test
    public void hasAllRoles() {
        System.out.println(subject.hasAllRoles(Arrays.asList("role1", "role2", "role3")));
    }

    /**
     * checkRole
     * 检查是否拥有该角色，没有会抛出UnauthorizedException异常
     */
    @Test
    public void checkRole() {
        subject.checkRole("role2");
    }

    /**
     * checkRoles
     * 检查是否拥有角色，没有某个角色会抛出UnauthorizedException异常
     */
    @Test
    public void checkRoles() {
        subject.checkRoles("role1", "role2");
    }
}
