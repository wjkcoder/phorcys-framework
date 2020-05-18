package cn.phorcys.framework.soa.aspect;

import cn.phorcys.framework.commons.exception.BusinessException;
import cn.phorcys.framework.commons.exception.PhorcysRuntimeException;
import cn.phorcys.framework.commons.logger.Logger;
import cn.phorcys.framework.commons.logger.LoggerFactory;
import cn.phorcys.framework.commons.model.BaseResponse;
import cn.phorcys.framework.commons.utility.object.ObjectUtil;
import cn.phorcys.framework.commons.utility.object.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/18 11:48 上午
 */
@Aspect
@Component
public class ControllerAspect {
    private Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object interceptor(ProceedingJoinPoint point){
        String canonicalName = point.getTarget().getClass().getCanonicalName();
        logger.info("Controller access " + canonicalName);
        long start = System.currentTimeMillis();
        Object response;
        try {
            response = point.proceed();
        } catch (Throwable e) {

            String message = e.getMessage();
            if (StringUtil.isNullOrEmptyOrWhitespace(message)) {
                message = e.toString();
            }
            String errorCode = e instanceof PhorcysRuntimeException ? ((PhorcysRuntimeException) e).getErrorCode() : null;
            long cost = System.currentTimeMillis() - start;
            logger.error("<<<<<<捕捉到业务层异常>>>>>" + message + "---" + errorCode);
            throw new BusinessException(message, errorCode, cost);
        }
        long cost = System.currentTimeMillis() - start;
        if (response instanceof BaseResponse) {
            ((BaseResponse) response).setCost(cost);
        }
        return response;
    }
}
