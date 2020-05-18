package cn.phorcys.framework.commons.exception;

public class NonNullOrEmptyException extends RuntimeException {
    public NonNullOrEmptyException() {
    }

    public NonNullOrEmptyException(String message) {
        super(message);
    }

    public NonNullOrEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonNullOrEmptyException(Throwable cause) {
        super(cause);
    }

    public NonNullOrEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
