package com.github.lkqm.weixin.gateway.core.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.Value;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Xml转Json字符串工具
 */
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class XmlConverter {

    private boolean keyCamelName;

    private static final XmlConverter defaultConvert = new XmlConverter(false);
    private static final XmlConverter camelConvert = new XmlConverter(true);

    /**
     * 转换xml到Map
     */
    public static Map<String, Object> convertToOrgMap(String xml) {
        return defaultConvert.convertToMap(xml);
    }

    /**
     * 转换xml到Map
     */
    public static Map<String, Object> convertToCamelMap(String xml) {
        return camelConvert.convertToMap(xml);
    }

    /**
     * 转换到map
     */
    @SneakyThrows
    private Map<String, Object> convertToMap(String xml) {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new StringReader(xml));
        Element root = document.getRootElement();
        List<Element> elements = root.elements();

        Map<String, Object> data = readElementAsStringOrMap(elements);
        return data != null ? data : new HashMap<String, Object>(0);
    }

    private Map<String, Object> readElementAsStringOrMap(List<Element> elements) {
        if (elements.size() == 0) return null;
        Map<String, Object> data = new HashMap<>(elements.size());
        for (Element ele : elements) {
            String key = getKeyName(ele.getName());
            Object value = readElementAsStringOrMap(ele.elements());
            if (value == null) {
                value = ele.getTextTrim();
            }
            data.put(key, value);
        }
        return data;
    }

    private String getKeyName(String tagName) {
        if (!keyCamelName) return tagName;
        return convertToCamelCase(tagName);
    }

    private static String convertToCamelCase(String text) {
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
