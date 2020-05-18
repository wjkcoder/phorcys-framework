package cn.phorcys.framework.commons.model;


import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/9 4:18 下午
 */
@Getter
@Setter
public class Result<M> implements IResult {
    private boolean successful;
    private String message;
    private String errorCode;
    private M data;


    @Override
    public void setSuccessful(boolean successful) {
        this.successful=successful;
    }

    @Override
    public void setMessage(String message) {
        this.message=message;
    }

    @Override
    public void setErrorCode(String errorCode) {
        this.errorCode=errorCode;
    }

    public Result(boolean successful, String message, String errorCode) {
        this.successful = successful;
        this.message = message;
        this.errorCode = errorCode;
    }
    public Result(boolean successful) {
        this(successful, null, null);
    }

    public Result(boolean successful, String message) {
        this(successful, message, null);
    }

    public static Result success() {
        return new Result(true);
    }

    public static Result success(String message) {
        return new Result(true, message);
    }

    public static Result fail() {
        return new Result(false);
    }

    public static Result fail(String message) {
        return new Result(false, message);
    }

    public static Result fail(String message, String errorCode) {
        return new Result(false, message, errorCode);
    }

    public Result setData(M data) {
        this.data = data;
        return this;
    }
}
