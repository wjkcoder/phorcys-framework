package cn.phorcys.framework.soa.commons;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/13 4:22 下午
 */
@Getter
@Setter
public class SessionInfo {
    private static TransmittableThreadLocal<SessionInfo> holder = new TransmittableThreadLocal<>();

    private Long userId;

    private Long tenantId;

    private Long sessionId;

    private String languageCode;

    private String userRealIP;

    private String userAgent;

    private String userReferer;

    private String userUrl;

    @Generated
    private Map<String, Object> extraInfos = new ConcurrentHashMap<>();

    public void setExtraInfo(String name, Object info) {
        extraInfos.put(name, info);
    }

    public Object getExtraInfo(String name) {
        return extraInfos.get(name);
    }

    public SessionInfo(Long sessionId, Long userId, Long tenantId) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.tenantId = tenantId;
    }

    public SessionInfo(Long sessionId, String languageCode, String userRealIP, String userUrl) {
        this.sessionId = sessionId;
        this.languageCode = languageCode;
        this.userRealIP = userRealIP;
        this.userUrl = userUrl;
    }

    public synchronized static void init(SessionInfo sessionInfo) {
        if (current() == null) {
            holder.set(sessionInfo);
        }
    }

    public static void destroy() {
        holder.remove();
    }

    @SuppressWarnings("WeakerAccess")
    public static SessionInfo current() {
        return holder.get();
    }

    public static String languageCode() {
        SessionInfo current = SessionInfo.current();
        if (current != null) {
            return current.getLanguageCode();
        }
        return "";
    }

    public static Long userId() {
        SessionInfo current = SessionInfo.current();
        if (current != null) {
            return current.getUserId();
        }
        return null;
    }

    public static Long tenantId() {
        SessionInfo current = SessionInfo.current();
        if (current != null) {
            return current.getTenantId();
        }
        return null;
    }

    public static Long sessionId() {
        SessionInfo current = SessionInfo.current();
        if (current != null) {
            return current.getSessionId();
        }
        return null;
    }

    public static String url() {
        SessionInfo current = SessionInfo.current();
        if (current != null) {
            return current.getUserUrl();
        }
        return "";
    }

    public static String agent() {
        SessionInfo current = SessionInfo.current();
        if (current != null) {
            return current.getUserAgent();
        }
        return "";
    }

    public static String ip() {
        SessionInfo current = SessionInfo.current();
        if (current != null) {
            return current.getUserRealIP();
        }
        return "";
    }

    public static String referer() {
        SessionInfo current = SessionInfo.current();
        if (current != null) {
            return current.getUserReferer();
        }
        return "";
    }
}
