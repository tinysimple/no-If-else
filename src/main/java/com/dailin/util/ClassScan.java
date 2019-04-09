package com.dailin.util;

import com.dailin.annotation.HandlerType;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassScan {

    public static void main(String[] args){
        ClassScan.getClasses("com.dailin.handler.biz", HandlerType.class).forEach(clazz -> {
            String type = clazz.getAnnotation(HandlerType.class).value();
            System.out.println(type);
        });
    }

    public static List<Class<?>> getClasses (String packageName, Class clazz) {
        List<Class<?>> list = new ArrayList();
        Enumeration<URL> iterator = null;
        try {
            iterator = Thread.currentThread().getContextClassLoader().getResources(packageName.replace(".", "/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        URL url = null;
        File file = null;
        File[] fls = null;
        Class<?> c = null;
        String className = null;
        while (iterator.hasMoreElements()) {
            url = iterator.nextElement();
            if ("file".equals(url.getProtocol())) {
                file = new File(url.getPath());
                if (file.isDirectory()) {
                    fls = file.listFiles();
                    for (File f: fls) {
                        className = f.getName();
                        className = className.substring(0, className.lastIndexOf("."));
                        try {
                            c = Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        if (c.isAnnotationPresent(clazz)) {
//                            c.getAnnotation(HandlerType.class).value();
                            list.add(c);
                            System.out.println(c);
                        }
                    }
                }
            }
        }
        return list;
    }
}
