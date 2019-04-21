package com.mario6.weixin.springboot.gateway.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBUtils {

    public final static String CHARSET_NAME = "UTF-8";

    public static String marshal(Object obj) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, CHARSET_NAME);

        StringWriter writer = new StringWriter();
        try {
            jaxbMarshaller.marshal(obj, writer);
            return writer.toString();
        } finally {
            close(writer);
        }
    }

    public static <T> T unmarshal(String xml, Class<T> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = null;
        try {
            reader = new StringReader(xml);
            return (T) jaxbUnmarshaller.unmarshal(reader);
        } finally {
            close(reader);
        }
    }

    private static void close(Closeable resource) {
        if (resource == null) {
            return;
        }
        try {
            resource.close();
        } catch (IOException e) {
        }
    }
}
