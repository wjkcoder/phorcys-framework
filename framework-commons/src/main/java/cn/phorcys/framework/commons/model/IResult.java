package cn.phorcys.framework.commons.model;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/9 4:15 下午
 */
public interface IResult {
    boolean isSuccessful();

    void setSuccessful(boolean successful);

    String getMessage();

    void setMessage(String message);

    String getErrorCode();

    void setErrorCode(String errorCode);
    default <T extends IResult> T fill(T targetResult) {
        targetResult.setSuccessful(this.isSuccessful());
        targetResult.setMessage(this.getMessage());
        targetResult.setErrorCode(this.getErrorCode());
        return targetResult;
    }
    static IResult success() {
        return new Result(true);
    }

    static IResult fail() {
        return new Result(false);
    }

    static IResult fail(String message) {
        return new Result(false, message);
    }

    static IResult fail(String message, String errorCode) {
        return new Result(false, message, errorCode);
    }
}
