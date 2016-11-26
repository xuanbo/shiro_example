package xinQing.shiro.chapter5.dao;

import org.junit.Test;
import xinQing.shiro.chapter5.util.EncryptUtil;

/**
 * Created by xuan on 16-11-23.
 */
public class EncryptTest {

    private String password = "111111";

    private String salt = "shiro_example";

    @Test
    public void md5() {
        System.out.println(EncryptUtil.encodeOnMd5(password, salt));
    }
}
