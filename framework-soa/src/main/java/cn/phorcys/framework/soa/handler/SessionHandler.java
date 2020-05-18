package cn.phorcys.framework.soa.handler;

import cn.phorcys.framework.commons.exception.ExceptionUtils;
import cn.phorcys.framework.commons.utility.object.ParseUtil;
import cn.phorcys.framework.commons.utility.object.StringUtil;
import cn.phorcys.framework.soa.commons.SessionInfo;
import cn.phorcys.framework.soa.constants.Headers;
import cn.phorcys.framework.soa.model.UserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/14 11:36 上午
 */
public class SessionHandler {
    public  static  void init (HttpServletRequest request){
        String psSessionId = request.getHeader(Headers.SessionId);
        String userRealIP = request.getHeader(Headers.UserRealIP);
        String userUrl = request.getHeader(Headers.UserUrl);
        Long sessionId = ParseUtil.tryLong(psSessionId);
        String languageCode = request.getHeader(Headers.LanguageCode);
        SessionInfo sessionInfo = new SessionInfo(sessionId, languageCode, userRealIP, userUrl);
        SessionInfo.init(sessionInfo);
    }
    public static void handle(HttpServletRequest request, UserInfo user){
        SessionHandler.init(request);
        if(user!=null){
            SessionInfo sessionInfo = SessionInfo.current();
                sessionInfo.setUserId(user.getUserId());
                sessionInfo.setSessionId(user.getSessionId());
                sessionInfo.setTenantId(user.getTenantId());
                if(StringUtil.isNullOrEmpty(sessionInfo.getLanguageCode())){
                    sessionInfo.setLanguageCode(user.getLanguageCode());
                }
            }else {
                ExceptionUtils.seed("User not login", "User not login");
            }
    }
}
