package per.ymm.weixiubao.utils;

/**
 * @Author: ymm
 * @Date: 2018/6/21 15:33
 * @Description:
 */
public class EngineerUtils {
    public static boolean isSpecialty(Integer n) {
        if (n == null || n == 4 || n == 5 || n == 6 || n == 7) {
            return true;
        }
        return false;
    }

    public static boolean isStstus(Integer n) {
        if (n == null ||n == 8 || n == 9) {
            return true;
        }
        return false;
    }

}
