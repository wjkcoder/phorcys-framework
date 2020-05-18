package cn.phorcys.framework.commons.utility.object;

import cn.phorcys.framework.commons.logger.Logger;
import cn.phorcys.framework.commons.logger.LoggerFactory;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/14 11:40 上午
 */
public class ParseUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParseUtil.class);

    private ParseUtil() {
    }

    @SuppressWarnings("all")
    public static boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }

    public static long tryLong(String str) {
        return tryLong(str, 0L);
    }

    public static long tryLong(String str, long defaultValue) {
        try {
            return Long.parseLong(str);
        } catch (Exception ignore) {
            return defaultValue;
        }
    }

    public static long tryLongWithException(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            LOGGER.error("ParseUtil", String.format("String \"%s\" can't convert to Long", str));
            throw new RuntimeException(e);
        }
    }

    public static Long tryLongOptional(String str) {
        if (StringUtil.isNullOrEmptyOrWhitespace(str)) {
            return null;
        }
        return tryLongWithException(str);
    }

    public static BigDecimal tryBigDecimal(String str) {
        return tryBigDecimal(str, BigDecimal.ZERO);
    }

    public static BigDecimal tryBigDecimal(String str, BigDecimal defaultValue) {
        Objects.requireNonNull(defaultValue);
        if (StringUtil.isNullOrEmptyOrWhitespace(str)) {
            return defaultValue;
        }
        try {
            return new BigDecimal(str);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static int tryInt(String str) {
        return tryInt(str, 0);
    }

    public static int tryInt(String str, int defaultValue) {
        try {
            Integer integer = new Integer(str);
            return integer;
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
