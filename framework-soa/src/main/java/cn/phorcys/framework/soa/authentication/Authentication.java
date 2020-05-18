package cn.phorcys.framework.soa.authentication;

import cn.phorcys.framework.commons.infrastructure.GlobalIdGenerate;
import cn.phorcys.framework.commons.infrastructure.SnowGenerator;
import cn.phorcys.framework.commons.utility.object.DateUtil;
import cn.phorcys.framework.redis.config.RedisClient;
import cn.phorcys.framework.soa.config.SecurityConfiguration;
import cn.phorcys.framework.soa.constants.RedisPrefix;
import cn.phorcys.framework.soa.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.security.util.SecurityConstants;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/14 11:00 上午
 */
@Component
public class Authentication implements Authorizer {
    @Autowired
    GlobalIdGenerate idGenerate;
    @Autowired
    SecurityConfiguration securityConfiguration;

    @Autowired
    RedisClient redisClient;
    public  static boolean isExpire(UserInfo userInfo){
        Calendar expiredTime = userInfo.getExpiredTime();
        return expiredTime.before(LocalDateTime.now());
    }

    @Override
    public Long login(Long tenantId, Long userId, String userName, String clientIP) {
        Long sessionId = idGenerate.nextId();
        Objects.requireNonNull(sessionId);
        UserInfo userInfo = new UserInfo();
        userInfo.setTenantId(tenantId);
        userInfo.setSessionId(sessionId);
        userInfo.setClientIP(clientIP);
        userInfo.setUsername(userName);
        userInfo.setUserId(userId);
        Calendar now = Calendar.getInstance();
        userInfo.setExpiresSeconds(securityConfiguration.getSessionExpiredSeconds());
        userInfo.setLoginTime(now);
        userInfo.setExpiredTime(DateUtil.addSeconds(now, securityConfiguration.getSessionExpiredSeconds()));

        login(sessionId, userInfo);
        return sessionId;
    }

    private void login(Long sessionId, UserInfo userInfo) {
        redisClient.set(RedisPrefix.SessionId(sessionId), userInfo,  securityConfiguration.getSessionExpiredSeconds(), TimeUnit.SECONDS);
        redisClient.set(RedisPrefix.CurrentUserSession(userInfo.getUserId()), userInfo, securityConfiguration.getSessionExpiredSeconds(), TimeUnit.SECONDS);
    }
}
