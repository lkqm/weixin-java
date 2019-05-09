package com.github.lkqm.weixin.gateway.core.util;

public class StringUtilsExt {

    public static String convertToCamelCase(String text) {
        StringBuilder name = new StringBuilder();
        char[] chars = text.toCharArray();
        boolean isNeedUpper = false;
        boolean isFirstChar = true;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '-' || c == '_' || c == '$' || c == '.') {
                isNeedUpper = true;
                continue;
            }
            if (isFirstChar) {
                name.append(Character.toLowerCase(c));
                isFirstChar = false;
                isNeedUpper = false;
                continue;
            }
            name.append(isNeedUpper ? Character.toUpperCase(c) : c);
            isNeedUpper = false;
        }
        return name.toString();
    }
}
