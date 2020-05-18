package cn.phorcys.framework.commons.model;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/9 4:49 下午
 */
public class GeneralResponse extends BaseResponse {
    public GeneralResponse(boolean successful, String message, String errorCode) {
        this.successful = successful;
        this.message = message;
        this.errorCode = errorCode;
    }
    public GeneralResponse(boolean successful) {
        this.successful = successful;
    }
    public GeneralResponse(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }
    public static GeneralResponse success() {
        return new GeneralResponse(true);
    }

    public static GeneralResponse fail() {
        return new GeneralResponse(false,null,null);
    }

    public static GeneralResponse fail(String message) {
        return new GeneralResponse(false, message,null);
    }

    public static GeneralResponse fail(String message, String errorCode) {
        return new GeneralResponse(false, message, errorCode);
    }

}
