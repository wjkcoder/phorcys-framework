package cn.phorcys.framework.soa.Interceptor;

import cn.phorcys.framework.commons.exception.AuthFailException;
import cn.phorcys.framework.commons.exception.BusinessException;
import cn.phorcys.framework.commons.exception.PhorcysRuntimeException;
import cn.phorcys.framework.commons.model.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/15 4:56 下午
 */
@ControllerAdvice
public class GlobalExceptionInterceptor {
    private class ErrorResponse extends BaseResponse {
        ErrorResponse(String message, String errorCode, String requestId, long cost) {
            this.successful = false;
            this.message = message;
            this.errorCode = errorCode;
            this.requestId = requestId;
            this.cost = cost;
        }
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse exceptionHandler(Exception exception) {
        if(exception instanceof AuthFailException){
            return new ErrorResponse(exception.getMessage(),((AuthFailException) exception).getErrorCode(),null,0);
        }
        if(exception instanceof BusinessException){
            return new ErrorResponse(exception.getMessage(),((BusinessException) exception).getErrorCode(),null,((BusinessException) exception).getCost());
        }
        if(exception instanceof PhorcysRuntimeException){
            return new ErrorResponse(exception.getMessage(),((PhorcysRuntimeException) exception).getErrorCode(),null,0);
        }else {
            exception.printStackTrace();
            return new ErrorResponse(exception.getMessage(),exception.getLocalizedMessage(),null,0);
        }
    }
}
