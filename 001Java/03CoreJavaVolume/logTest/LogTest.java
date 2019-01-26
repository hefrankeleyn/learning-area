import java.util.logging.Level;
import java.util.   logging.Logger;

/**
 * LogTest
 */
public class LogTest {
    // industrial-strength log
    private static final Logger myLogger = Logger.getLogger("exceptions.logging");
    

    public static void main(String[] args) {
        //baseLog();
        myLogger.setLevel(Level.FINE);
        industrialStrengthLog();
    }
    
    public static void industrialStrengthLog(){
        // 默认记录前三个级别的日志
        /*
        myLogger.severe("severe log....");
        myLogger.warning("warning  log...");
        myLogger.info("info log...");
        */
        //myLogger.logp(Level.INFO, "LogTest", "industrialStrengthLog", "logp log...");

        //myLogger.entering("LogTest", "industrialStrengthLog");
        
        // 后面几个级别，需要开启，否则不会有记录
		
        //myLogger.config("config log...");
        myLogger.fine("industrial strength fine log...");

    }

    public static void baseLog(){
        Logger.getGlobal().info("File->Open menu item selected.");
    }
}