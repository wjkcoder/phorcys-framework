package cn.phorcys.framework.commons.logger;

import cn.phorcys.framework.commons.exception.ExceptionUtils;
import cn.phorcys.framework.commons.logger.imp.GeneralFactory;
import cn.phorcys.framework.commons.utility.object.ObjectUtil;

import java.util.concurrent.ConcurrentHashMap;

public class LoggerFactory {
    private static final String DEFAULT_FACTORY = "general";
    private static final ConcurrentHashMap<String, ILoggerFactory> factoryMaps = new ConcurrentHashMap<>();
    private static ILoggerFactory currentFactory = null;

    private static void add(String name, ILoggerFactory factory) {
        factoryMaps.put(name, factory);
    }

    private static void setCurrentFactory(String name) {
        ILoggerFactory iLoggerFactory = factoryMaps.get(name);
        if (iLoggerFactory == null) {
            ExceptionUtils.seed(name + " factory not found!");
        }
        currentFactory = iLoggerFactory;
    }

    public static Logger getLogger(Class<?> clazz) {
        if (currentFactory == null && ObjectUtil.isEmpty(factoryMaps)) {
            add(DEFAULT_FACTORY, new GeneralFactory());
            setCurrentFactory(DEFAULT_FACTORY);
        }
        return currentFactory.getLogger(clazz);
    }

    public static Logger getLogger(String name) {
        if (currentFactory == null && ObjectUtil.isEmpty(factoryMaps)) {
            add("general", new GeneralFactory());
        }
        return currentFactory.getLogger(name);
    }

}
