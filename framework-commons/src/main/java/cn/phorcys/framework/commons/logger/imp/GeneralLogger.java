package cn.phorcys.framework.commons.logger.imp;

import cn.phorcys.framework.commons.logger.Logger;

import java.util.Map;

public class GeneralLogger implements Logger {
    private static final String MSG_WITH_TITLE = "{}: {}";
    private static final String MSG_WITH_TITLE_ATTRS = "{}: {}\n{}";
    private static final String MSG_WITH_ATTRS = "{}\n{}";
    private org.slf4j.Logger _logger;

    GeneralLogger(org.slf4j.Logger logger) {
        this._logger = logger;
    }

    public void debug(String title, String message) {
        _logger.debug(MSG_WITH_TITLE, title, message);
    }

    public void debug(String title, Throwable throwable) {
        _logger.debug(title, throwable);
    }

    public void debug(String title, String message, Map<String, String> attrs) {

    }

    public void debug(String title, Throwable throwable, Map<String, String> attrs) {

    }

    public void debug(String message) {
        _logger.debug(message);
    }

    public void debug(Throwable throwable) {
        _logger.debug(throwable.getMessage(), throwable);
    }

    public void debug(String message, Map<String, String> attrs) {

    }

    public void debug(Throwable throwable, Map<String, String> attrs) {

    }

    public void info(String title, String message) {
        _logger.info(MSG_WITH_TITLE, title, message);
    }

    public void info(String title, Throwable throwable) {
        _logger.info(MSG_WITH_TITLE, title, throwable);
    }

    public void info(String title, String message, Map<String, String> attrs) {

    }

    public void info(String title, Throwable throwable, Map<String, String> attrs) {

    }

    public void info(String message) {
        _logger.info(message);
    }

    public void info(Throwable throwable) {
        _logger.info(throwable.getMessage(),throwable);
    }

    public void info(String message, Map<String, String> attrs) {

    }

    public void info(Throwable throwable, Map<String, String> attrs) {

    }

    public void warn(String title, String message) {

    }

    public void warn(String title, Throwable throwable) {

    }

    public void warn(String title, String message, Map<String, String> attrs) {

    }

    public void warn(String title, Throwable throwable, Map<String, String> attrs) {

    }

    public void warn(String message) {
        _logger.warn(message);
    }

    public void warn(Throwable throwable) {

    }

    public void warn(String message, Map<String, String> attrs) {

    }

    public void warn(Throwable throwable, Map<String, String> attrs) {

    }

    public void error(String title, String message) {

    }

    public void error(String title, Throwable throwable) {

    }

    public void error(String title, String message, Throwable throwable) {

    }

    public void error(String title, String message, Map<String, String> attrs) {

    }

    public void error(String title, Throwable throwable, Map<String, String> attrs) {

    }

    public void error(String title, String message, Throwable throwable, Map<String, String> attrs) {

    }

    public void error(String message) {
        _logger.error(message);
    }

    public void error(Throwable throwable) {

    }

    public void error(String message, Map<String, String> attrs) {

    }

    public void error(Throwable throwable, Map<String, String> attrs) {

    }

    public void fatal(String title, String message) {

    }

    public void fatal(String title, Throwable throwable) {

    }

    public void fatal(String title, String message, Map<String, String> attrs) {

    }

    public void fatal(String title, Throwable throwable, Map<String, String> attrs) {

    }

    public void fatal(String message) {

    }

    public void fatal(Throwable throwable) {

    }

    public void fatal(String message, Map<String, String> attrs) {

    }

    public void fatal(Throwable throwable, Map<String, String> attrs) {

    }
}
