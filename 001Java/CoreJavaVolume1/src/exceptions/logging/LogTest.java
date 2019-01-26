package exceptions.logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.   logging.Logger;

/**
 * LogTest
 */
public class LogTest {
    // industrial-strength log
    private static final Logger myLogger = Logger.getLogger("exceptions.logging");
    
    public static void main(String[] args) {
        /*
        //baseLog();
        myLogger.setLevel(Level.FINER);
        //finerLog();
        
        logHandler(Level.FINER);
        configLog();
        finerLog();
        */
        readAllLog();
        fileHandler();
        threeClassLogLevel();
    }
    /**
     * 确保将所有的消息记录到应用程序特定文件中
     */
    public static void readAllLog(){
        if(System.getProperty("java.util.logging.config.class") == null
           && System.getProperty("java.util.logging.config.file") == null)
        {
            try {
                Logger.getLogger("").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/myapp.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("").addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger("").log(Level.SEVERE, "Can't create log file handler", e);
            }
        }
    }

    public static void threeClassLogLevel(){
        myLogger.severe("severe log....");
        myLogger.warning("warning  log...");
        myLogger.info("info log...");
    }
    public static void industrialStrengthLog(){
        // 默认记录前三个级别的日志
        
        myLogger.severe("severe log....");
        myLogger.warning("warning  log...");
        myLogger.info("info log...");
        
        //myLogger.logp(Level.INFO, "LogTest", "industrialStrengthLog", "logp log...");

        //myLogger.entering("LogTest", "industrialStrengthLog");
        
        // 后面几个级别，需要开启，否则不会有记录
        
        myLogger.config("config log...");
        //myLogger.fine("industrial strength fine log...");
        //myLogger.finer("finer log...");
    }

    public static void finerLog(){
        myLogger.finer("finer log...");
    }

    public static void configLog(){
        myLogger.config("config log...");
    }

    public static void baseLog(){
        Logger.getGlobal().info("File->Open menu item selected.");
    }

    public static void logHandler(Level lev){
       // myLogger.setUseParentHandlers(false);
        Handler handler = new ConsoleHandler();
        handler.setLevel(lev);
        myLogger.addHandler(handler);
    }

    public static void fileHandler(){
        try {
            FileHandler fileHandler = new FileHandler();
            myLogger.addHandler(fileHandler);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

    }
}