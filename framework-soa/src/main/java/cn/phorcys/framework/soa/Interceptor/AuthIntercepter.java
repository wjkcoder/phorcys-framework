package cn.phorcys.framework.soa.Interceptor;

import cn.phorcys.framework.commons.exception.ExceptionUtils;
import cn.phorcys.framework.commons.exception.PhorcysRuntimeException;
import cn.phorcys.framework.commons.utility.object.ObjectUtil;
import cn.phorcys.framework.commons.utility.object.ParseUtil;
import cn.phorcys.framework.commons.utility.object.StringUtil;
import cn.phorcys.framework.redis.config.RedisClient;
import cn.phorcys.framework.soa.annotation.AuthenticateSkip;
import cn.phorcys.framework.soa.authentication.Authentication;
import cn.phorcys.framework.soa.constants.Headers;
import cn.phorcys.framework.soa.constants.RedisPrefix;
import cn.phorcys.framework.soa.handler.SessionHandler;
import cn.phorcys.framework.soa.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/10 11:47 下午
 */
@Component
public class AuthIntercepter extends HandlerInterceptorAdapter{
    @Autowired
    RedisClient redisClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String sessionId = request.getHeader(Headers.SessionId);
        if (StringUtil.isNullOrEmpty(sessionId)) {
            // 1. sessionId is null, check method annotation
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            AuthenticateSkip annotation = method.getAnnotation(AuthenticateSkip.class);
            if (!ObjectUtil.isEmpty(annotation) && annotation.permission()) {
                SessionHandler.init(request);
                return true;
            }
            // no skip annotation , all request need auth
            ExceptionUtils.seed("User need login ,please check status");
        }
        // sessionId is not null,check user status

        Object o = redisClient.get(RedisPrefix.SessionId(ParseUtil.tryLong(sessionId)));
        if(o==null){
            ExceptionUtils.seed("会话实效，请重新登录");
        }
        if(o instanceof UserInfo){
            UserInfo userInfo = (UserInfo)o;
            if(Authentication.isExpire(userInfo)){
                ExceptionUtils.seed("token expire ,please login again");
            }
            // is valid ，fill sessionInfo
            SessionHandler.handle(request,userInfo);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(ex instanceof PhorcysRuntimeException){
            ex.printStackTrace();
        }
    }
}
