package xinQing.shiro.chapter3;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * shiro
 *
 * Created by xuan on 16-11-17.
 */
public class ShiroUtil {

    /**
     * 登录
     *
     * @param iniPath ini配置文件的路径
     * @param username 用户名
     * @param password 密码
     */
    public static Subject login(String iniPath, String username, String password) {
        // 1.获取SecurityManager工厂,此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:" + iniPath);

        // 2.得到SecurityManager实例,并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 3.得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            // 4.登录,即身份验证
            subject.login(token);
            System.out.println("认证成功！");
        } catch (AuthenticationException e) {
            // 5.身份验证失败
            e.printStackTrace();
            System.out.println("认证失败！");
        }
        return subject;
    }

}
