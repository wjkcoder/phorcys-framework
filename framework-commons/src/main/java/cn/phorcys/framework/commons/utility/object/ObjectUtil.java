package cn.phorcys.framework.commons.utility.object;

import java.util.Collection;
import java.util.Map;

public class ObjectUtil {
    public static <T> boolean isNullOrEmpty(T[] array) {
        return array == null || array.length == 0;
    }
    public static boolean isNullOrEmpty(Map map) {
        return map == null || map.size() == 0;
    }
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }
    public static boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }
    public static boolean isEmpty(Object obj) {
        if(obj == null) {
            return true;
        }

        if(obj instanceof String) {
            return ((String) obj).isEmpty();
        }

        if(obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }

        if(obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }
}
