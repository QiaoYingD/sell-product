package com.imooc.sellproduct.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class JsonUtil {


    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转json
     * @param typeClass
     * @return
     */
    public static String toJson(Object  typeClass) {
        try {
            return objectMapper.writeValueAsString(typeClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param string
     * @param typeClass
     * @return
     */
    public static Object fromJson(String string, Class typeClass) {
        try {
            return objectMapper.readValue(string, typeClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json转集合对象
     *
     * @param string
     * @param typeReference
     * @return
     */
    public static Object fromJson(String string, TypeReference typeReference) {
        try {
            return objectMapper.readValue(string, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
