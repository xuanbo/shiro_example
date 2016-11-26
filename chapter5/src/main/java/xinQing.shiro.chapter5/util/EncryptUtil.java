package xinQing.shiro.chapter5.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 加密工具类，基于shiro支持
 *
 * Created by xuan on 16-11-23.
 */
public class EncryptUtil {

    /**
     * Base64加密
     *
     * @param str 要加密的字符串
     * @return Base64加密后的字符串
     */
    public static String encodeOnBase64(String str) {
        return Base64.decodeToString(str);
    }

    /**
     * Base64解密
     *
     * @param str 要解密的字符串
     * @return Base64解密后的字符串
     */
    public static String decodeOnBase64(String str) {
        return Base64.decodeToString(str);
    }

    /**
     * md5加密
     *
     * @param str 要加密的字符串
     * @param salt 盐值
     * @return md5加密后的字符串
     */
    public static String encodeOnMd5(String str, String salt) {
        return new Md5Hash(str, salt).toString();
    }
}
