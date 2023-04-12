package datn.qlkt.ultis;

public class NumberUtils {
    public static boolean isNull(Integer num) {
        return null == num;
    }

    public static boolean isNull(Long num) {
        return null == num;
    }

    public static boolean isNotNull(Integer num) {
        return !isNull(num);
    }

    public static boolean isNotNull(Long num) {
        return !isNull(num);
    }

    public static boolean greatThenZero(Long num) {
        return isNotNull(num) && num > 0;
    }

    public static boolean greatThenZero(Integer num) {
        return isNotNull(num) && num > 0;
    }
}
