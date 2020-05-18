package cn.phorcys.framework.commons.logger.imp;

import cn.phorcys.framework.commons.logger.ILoggerFactory;
import cn.phorcys.framework.commons.logger.Logger;
import org.slf4j.LoggerFactory;

public class GeneralFactory implements ILoggerFactory {
    public Logger getLogger(Class<?> clazz) {
        return  new GeneralLogger(LoggerFactory.getLogger(clazz));
    }

    public Logger getLogger(String name) {
        return new GeneralLogger(LoggerFactory.getLogger(name));
    }
}
