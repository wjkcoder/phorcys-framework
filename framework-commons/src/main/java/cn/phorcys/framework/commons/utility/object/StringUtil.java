package cn.phorcys.framework.commons.utility.object;

import cn.phorcys.framework.commons.exception.PhorcysRuntimeException;
import cn.phorcys.framework.commons.exception.NonNullOrEmptyException;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

/**
 * StringUtil
 *
 * @author lanmi.xin@gmail.com
 * Created on 2018-07-12 19:10
 */
@SuppressWarnings("unused")
public class StringUtil {

    private static char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final String EMPTY = "";

    private static final String UTF8 = "UTF-8";

    public static boolean isNullOrEmpty(String text) {
        return ObjectUtil.isNullOrEmpty(text);
    }

    public static boolean isNullOrEmptyOrWhitespace(String text) {
        return isNullOrEmpty(text) || text.trim().isEmpty();
    }

    public static String requireNonNullOrEmpty(String str) {
        if (isNullOrEmpty(str)) {
            throw new NonNullOrEmptyException();
        }
        return str;
    }

    public static String requireNonNullOrEmpty(String str, String message) {
        if (isNullOrEmpty(str)) {
            throw new NonNullOrEmptyException(message);
        }
        return str;
    }

    public static void requireNonNullOrEmptyOrWhitespace(String str) {
        if (isNullOrEmptyOrWhitespace(str)) {
            throw new NonNullOrEmptyException();
        }
    }

    public static void requireNonNullOrEmptyOrWhitespace(String str, String message) {
        if (isNullOrEmptyOrWhitespace(str)) {
            throw new NonNullOrEmptyException(message);
        }
    }

    /**
     * 获取 snippet 在 text 中重复出现的次数。
     */
    public static int getExistsTimesInString(String text, String snippet) {
        if (isNullOrEmpty(text) || isNullOrEmpty(snippet)) {
            return 0;
        }
        if (Objects.equals(text, snippet)) {
            return 1;
        }
        return text.split(snippet).length - 1 + (Objects.equals(trimRight(text, snippet), text) ? 0 : 1);
    }


    public static String trimRight(String text, String snippet) {
        if (ObjectUtil.isNullOrEmpty(text) || ObjectUtil.isNullOrEmpty(snippet) || text.length() < snippet.length()) {
            return text;
        }
        int length = snippet.length();
        return Objects.equals(text.substring(text.length() - length), snippet)
                ? trimRight(text.substring(0, text.length() - length), snippet)
                : text;
    }

    public static String trimLeft(String text, String snippet) {
        if (ObjectUtil.isNullOrEmpty(text) || ObjectUtil.isNullOrEmpty(snippet) || text.length() < snippet.length()) {
            return text;
        }
        int length = snippet.length();
        return Objects.equals(text.substring(0, length), snippet)
                ? trimLeft(text.substring(length), snippet)
                : text;
    }

    public static String trim(String text, String snippet) {
        if (ObjectUtil.isNullOrEmpty(text) || ObjectUtil.isNullOrEmpty(snippet)) {
            return text;
        }
        return trimLeft(trimRight(text, snippet), snippet);
    }

    public static String trim(String text) {
        if (isNullOrEmpty(text)) {
            return text;
        }
        return text.trim();
    }

    public static String toLowerCase(String text) {
        if (text == null) {
            return EMPTY;
        }
        return text.toLowerCase();
    }

    public static String toLowerCaseWithException(String text) {
        if (text == null) {
            throw new NullPointerException("StringUtil.toLowerCase(String text)");
        }
        return text.toLowerCase();
    }

    public static String toUpperCase(String text) {
        if (text == null) {
            throw new NullPointerException("StringUtil.toUpperCase(String text)");
        }
        return text.toUpperCase();
    }

    @SuppressWarnings("SimplifiableIfStatement")
    public static boolean equalsIgnoreCase(String a, String b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null) return false;
        if (b == null) return false;

        return a.equalsIgnoreCase(b);
    }

    public static byte[] getUTF8Buffer(String str) {
        Objects.requireNonNull(str);
        try {
            return str.getBytes(UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new PhorcysRuntimeException(e.getMessage());
        }
    }

    public static String toHexString(byte[] buffer) {
        StringBuilder sb = new StringBuilder(buffer.length * 2);
        for (byte b : buffer) {
            sb.append(HEX_CHAR[(b & 0xf0) >>> 4]);
            sb.append(HEX_CHAR[b & 0x0f]);
        }
        return sb.toString();
    }

    public static byte[] toHexBuffer(String hex) {
        Objects.requireNonNull(hex);
        byte[] buffer = new byte[hex.length() / 2];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2),
                    16);
        }
        return buffer;
    }

    public static String nvl(String value1, String value2) {
        return isNullOrEmptyOrWhitespace(value1) ? value2 : value1;
    }

    public static String nvl2(String value1, String value2, String value3) {
        return isNullOrEmptyOrWhitespace(value1) ? value3 : value2;
    }
}
