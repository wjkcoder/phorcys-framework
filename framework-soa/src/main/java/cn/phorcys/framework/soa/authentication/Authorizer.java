package cn.phorcys.framework.soa.authentication;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/14 5:25 下午
 */
public interface Authorizer {

     Long login(Long tenantId, Long userId, String userName, String clientIP);

    }
