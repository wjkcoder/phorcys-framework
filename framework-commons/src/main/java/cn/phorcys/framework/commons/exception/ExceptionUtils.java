package cn.phorcys.framework.commons.exception;

public class ExceptionUtils {
    public static void seed(String msg, String error) {
        throw new PhorcysRuntimeException(msg, error);
    }

    public static void seed(String msg) {
        throw new PhorcysRuntimeException(msg);
    }
    public static void unLogin(String msg){
        throw new AuthFailException(msg);
    }

    public static void seed() {
        throw new PhorcysRuntimeException();
    }
}
