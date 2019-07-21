package cn.fuzongyao.demo.result.util;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-07-20 13:14
 * @since 1.0
 */
public class StringUtil {
    public static String replacePhone(String phone) {
        if (phone == null) {
            throw new AssertionError();
        }
        if (phone.length() != 11) {
            throw new AssertionError("手机号必须是11位");
        }
        return String.format("%s****%s", phone.substring(0, 3), phone.substring(phone.length() - 4));
    }

}
