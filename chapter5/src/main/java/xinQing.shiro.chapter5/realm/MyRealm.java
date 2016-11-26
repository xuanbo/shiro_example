package xinQing.shiro.chapter5.realm;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import xinQing.shiro.chapter5.dao.PermissionDao;
import xinQing.shiro.chapter5.dao.RoleDao;
import xinQing.shiro.chapter5.dao.UserDao;
import xinQing.shiro.chapter5.dao.impl.JdbcPermissionDaoImpl;
import xinQing.shiro.chapter5.dao.impl.JdbcRoleDaoImpl;
import xinQing.shiro.chapter5.dao.impl.JdbcUserDaoImpl;
import xinQing.shiro.chapter5.entity.Role;
import xinQing.shiro.chapter5.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 自定义Realm
 *
 * Created by xuan on 16-11-21.
 */
public class MyRealm extends AuthorizingRealm {

    private static final Logger log = Logger.getLogger(MyRealm.class);

    private UserDao userDao;
    private RoleDao roleDao;
    private PermissionDao permissionDao;

    public MyRealm() {
        this.userDao = new JdbcUserDaoImpl();
        this.roleDao = new JdbcRoleDaoImpl();
        this.permissionDao = new JdbcPermissionDaoImpl();
    }

    /**
     * 授权
     * 提取当事人的角色和权限
     *
     * @param principalCollection PrincipalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名
        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        log.debug("================================================");
        log.debug("username:" + username);
        log.debug("================================================");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        try {
            User user = userDao.getByUsername(username);
            Role role = roleDao.getById(user.getId());
            log.debug("================================================");
            log.debug("role:" + role);
            log.debug("================================================");
            info.addRole(role.getName());
            Collection<String> permissionNames = new ArrayList<>();
            permissionDao.getByRoleId(role.getId()).forEach(permission -> {
                String permissionName = permission.getName();
                log.debug("================================================");
                log.debug("permission:" + permission);
                log.debug("================================================");
                permissionNames.add(permissionName);
            });
            info.addStringPermissions(permissionNames);
            return info;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 身份认证
     *
     * @param authenticationToken AuthenticationToken
     * @return SimpleAuthenticationInfo
     * @throws AuthenticationException AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户名
        String username = (String) authenticationToken.getPrincipal();
        log.debug("================================================");
        log.debug("login:" + username);
        log.debug("================================================");
        try {
            User user = userDao.getByUsername(username);
            // 此处无需比对，比对的逻辑Shiro会做，我们只需返回一个和令牌相关的正确的验证信息
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
