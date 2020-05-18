package cn.phorcys.framework.commons.exception;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/15 5:03 下午
 */
public class AuthFailException extends PhorcysRuntimeException {
    private String errorCode;

    public AuthFailException(String message) {
        super(message);
    }

    public AuthFailException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
