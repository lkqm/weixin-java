package com.mario6.weixin.gateway.core.util;

import com.mario6.weixin.gateway.base.WxXmlMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class WxMessageUtils {

    public static WxXmlMessage createFromXml(String xml) {
        try {
            WxXmlMessage message = JAXBUtils.unmarshal(xml, WxXmlMessage.class);
            message.setXmlData(xml);
            message.setXmlMapData(convertXmlToMap(xml));
            return message;
        } catch (JAXBException | DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, String> convertXmlToMap(String xml) throws DocumentException {
        Map<String, String> map = new HashMap<>(16);
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new StringReader(xml));
        Element root = document.getRootElement();
        List<Element> elements = root.elements();
        for (Element ele : elements) {
            String name = ele.getName();
            String text = ele.getStringValue();
            map.put(name, text);
        }
        return map;
    }

}
