package life.yaya.conf;

import life.yaya.util.LogUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author xuan
 * GlobalConf， 用于在程序启动后加载一些配置
 */
public class GlobalConf {
    public static String fictionDir=null;
    public static String charset=null;
    public static String downloaderDir=null;
    public static String error404="\"msg\":\"404\"";
    static {
        Properties properties=new Properties();
        try {
            properties.load(new InputStreamReader(new FileInputStream(GlobalConf.class.getResource("/").getPath()+"/etc/conf.properties")));
            fictionDir=properties.getProperty("fictionDir");
            charset=properties.getProperty("charset");
            downloaderDir=properties.getProperty("downloadDir");
            LogUtil.i(fictionDir);
            LogUtil.i(charset);
            LogUtil.i(downloaderDir);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            properties.clear();
        }
    }
}
