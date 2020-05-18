package cn.phorcys.framework.commons.exception;


public class PhorcysRuntimeException extends RuntimeException {
    private String errorCode;

    public PhorcysRuntimeException() {
    }

    public PhorcysRuntimeException(String message) {
        super(message);
    }

    public PhorcysRuntimeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
