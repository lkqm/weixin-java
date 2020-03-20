package com.github.lkqm.weixin.gateway.core.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

    public static boolean isAnyEmpty(String... texts) {
        for (String text : texts) {
            if (text == null || text.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static String join(String[] elements, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i != elements.length - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    public static boolean equalsIgnoreCase(String text1, String text2) {
        if (text1 != null) {
            return text1.equalsIgnoreCase(text2);
        }
        if (text2 != null) {
            return text2.equalsIgnoreCase(text1);
        }
        return true;
    }
}
