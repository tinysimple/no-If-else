package com.dailin.handler;

import com.dailin.abstracts.AbstractHandler;
import com.dailin.util.SpringContextHelper;
import org.springframework.stereotype.Component;

import java.util.Map;

//@Component
public class HandlerContext {
    private Map<String, Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(String type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("not found handler for type: " + type);
        }
        return (AbstractHandler) SpringContextHelper.getBean(clazz);
    }
}
