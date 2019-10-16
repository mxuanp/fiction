package life.yaya.util;

/**
 * LogUtil, print info, error msg
 */
public class LogUtil {
    private static final int level = 1;
    private static final int INFO = 1;
    private static final int ERROR = 2;

    /**
     * print info msg
     * @param msg
     */
    public static void i(String msg) {
        if (level <= INFO)
            System.out.println(msg);
    }

    /**
     * print error msg
     * @param msg
     */
    public static void e(String msg) {
        if (level <= ERROR)
            System.err.println(msg);
    }
}
