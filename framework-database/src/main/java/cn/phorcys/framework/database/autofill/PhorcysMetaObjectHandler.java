package cn.phorcys.framework.database.autofill;

import cn.phorcys.framework.commons.logger.Logger;
import cn.phorcys.framework.commons.logger.LoggerFactory;
import cn.phorcys.framework.soa.commons.SessionInfo;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/13 4:01 下午
 */
@Component
public class PhorcysMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATED_BY = "createdBy";
    private static final String CREATION_DATE = "creationDate";
    private static final String LAST_UPDATED_BY = "lastUpdatedBy";
    private static final String LAST_UPDATE_DATE = "lastUpdateDate";
    private static final String LAST_UPDATE_LOGIN = "lastUpdateLogin";
    private static final String VERSION_ID = "versionId";
    private static final String ID = "id";
    private static final String TENANT_ID = "tenantId";
    private static final String LANGUAGE_CODE = "languageCode";
    private static final String DELETE_FLAG = "deleteFlag";


    Logger log = LoggerFactory.getLogger(PhorcysMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        // 获取当前的用户数据
        SessionInfo current = SessionInfo.current();

        log.info("******* insertFill start *******");
        setFieldValByName(CREATED_BY, current.getUserId(), metaObject);
        setFieldValByName(LAST_UPDATED_BY, current.getUserId(), metaObject);
        setFieldValByName(LAST_UPDATE_LOGIN, current.getSessionId(), metaObject);
        setFieldValByName(DELETE_FLAG, false, metaObject);
        this.strictInsertFill(metaObject, CREATION_DATE, LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, LAST_UPDATE_DATE, LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)

        log.info("******* insertFill finished *******");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 获取当前的用户数据
        SessionInfo current = SessionInfo.current();

        log.info("******* updateFill start *******");
        setFieldValByName(LAST_UPDATED_BY, current.getUserId(), metaObject);
        this.strictInsertFill(metaObject, LAST_UPDATE_DATE, LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)

        log.info("******* updateFill finished *******");
    }
}
