package cn.phorcys.framework.commons.logger;

public interface ILoggerFactory {
    Logger getLogger(Class<?> clazz);

    Logger getLogger(String name);
}
