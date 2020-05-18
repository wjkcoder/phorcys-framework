package cn.phorcys.framework.commons.logger;

import java.util.Map;

public interface Logger {
    void debug(String title, String message);

    void debug(String title, Throwable throwable);

    void debug(String title, String message, Map<String, String> attrs);

    void debug(String title, Throwable throwable, Map<String, String> attrs);

    void debug(String message);

    void debug(Throwable throwable);

    void debug(String message, Map<String, String> attrs);

    void debug(Throwable throwable, Map<String, String> attrs);

    void info(String title, String message);

    void info(String title, Throwable throwable);

    void info(String title, String message, Map<String, String> attrs);

    void info(String title, Throwable throwable, Map<String, String> attrs);

    void info(String message);

    void info(Throwable throwable);

    void info(String message, Map<String, String> attrs);

    void info(Throwable throwable, Map<String, String> attrs);

    void warn(String title, String message);

    void warn(String title, Throwable throwable);

    void warn(String title, String message, Map<String, String> attrs);

    void warn(String title, Throwable throwable, Map<String, String> attrs);

    void warn(String message);

    void warn(Throwable throwable);

    void warn(String message, Map<String, String> attrs);

    void warn(Throwable throwable, Map<String, String> attrs);

    void error(String title, String message);

    void error(String title, Throwable throwable);

    void error(String title, String message, Throwable throwable);

    void error(String title, String message, Map<String, String> attrs);

    void error(String title, Throwable throwable, Map<String, String> attrs);

    void error(String title, String message, Throwable throwable, Map<String, String> attrs);

    void error(String message);

    void error(Throwable throwable);

    void error(String message, Map<String, String> attrs);

    void error(Throwable throwable, Map<String, String> attrs);

    void fatal(String title, String message);

    void fatal(String title, Throwable throwable);

    void fatal(String title, String message, Map<String, String> attrs);

    void fatal(String title, Throwable throwable, Map<String, String> attrs);

    void fatal(String message);

    void fatal(Throwable throwable);

    void fatal(String message, Map<String, String> attrs);

    void fatal(Throwable throwable, Map<String, String> attrs);
}
