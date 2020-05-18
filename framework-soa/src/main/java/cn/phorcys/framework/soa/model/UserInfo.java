package cn.phorcys.framework.soa.model;

import cn.phorcys.framework.soa.commons.SessionInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/13 4:42 下午
 */
@Getter
@Setter
public class UserInfo implements Serializable {
    private Long tenantId;
    private Long userId;
    private String username;
    private Long sessionId;
    private Calendar loginTime;
    private Calendar expiredTime;
    private long expiresSeconds;
    private String systemName;
    private String clientIP;
    private String languageCode = "zh_CN";
}
