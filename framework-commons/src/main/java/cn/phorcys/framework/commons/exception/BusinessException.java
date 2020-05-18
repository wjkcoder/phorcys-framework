package cn.phorcys.framework.commons.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/18 2:37 下午
 */
@Getter
@Setter
public class BusinessException extends PhorcysRuntimeException {
    private String errorCode;
    private long cost;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, String errorCode, long cost) {
        super(message);
        this.errorCode = errorCode;
        this.cost = cost;
    }
}
