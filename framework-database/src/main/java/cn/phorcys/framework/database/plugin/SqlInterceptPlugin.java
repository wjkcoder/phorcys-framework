package cn.phorcys.framework.database.plugin;

import cn.phorcys.framework.commons.logger.Logger;
import cn.phorcys.framework.commons.logger.LoggerFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/15 4:09 下午
 */
@Component
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class SqlInterceptPlugin implements Interceptor {
    private Logger logger = LoggerFactory.getLogger(SqlInterceptPlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String oldSql = boundSql.getSql();
        logger.info("SQL INFO: " + oldSql + "\n");
        return invocation.proceed();

    }
}
