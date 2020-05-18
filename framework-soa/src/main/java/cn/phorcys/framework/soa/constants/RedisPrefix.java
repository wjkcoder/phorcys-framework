package cn.phorcys.framework.soa.constants;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/14 5:51 下午
 */
public interface RedisPrefix {
    String KEY_PREFIX = "Phorcys_OAuth";

    static String SessionId(Long sessionId) {
        return KEY_PREFIX + "SessionId_" + "_" + sessionId;
    }

    static String CurrentUserSession(Long userId) {
        return KEY_PREFIX + "SessionId_" + "_" + userId;
    }
}
