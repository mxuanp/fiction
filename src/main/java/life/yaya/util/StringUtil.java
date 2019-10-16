package life.yaya.util;

/**
 * StringUtil, a util class for String
 */
public class StringUtil {
    /**
     * splice String
     * @param args
     * @return String
     */
    public static String splicingString(String... args){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<args.length;i++){
            stringBuilder.append(args[i]);
        }
        return stringBuilder.toString();
    }
}
