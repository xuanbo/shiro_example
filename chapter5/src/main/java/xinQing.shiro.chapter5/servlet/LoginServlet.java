package xinQing.shiro.chapter5.servlet;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import xinQing.shiro.chapter5.util.EncryptUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Login
 *
 * Created by xuan on 16-11-18.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断是否是rememberMe
        Subject subject = SecurityUtils.getSubject();
        if(subject.isRemembered()){
            resp.sendRedirect("/success.jsp");
            return;
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean rememberMe = Boolean.parseBoolean(req.getParameter("rememberMe"));
        log.debug("-----------------------------------------------");
        log.debug("rememberMe:" + rememberMe);
        log.debug("-----------------------------------------------");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, EncryptUtil.encodeOnMd5(password, "shiro_example"));
        // 设置rememberMe
        token.setRememberMe(rememberMe);
        try {
            subject.login(token);
            resp.sendRedirect("/success.jsp");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            req.setAttribute("error", "用户名不存在或密码不正确！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
