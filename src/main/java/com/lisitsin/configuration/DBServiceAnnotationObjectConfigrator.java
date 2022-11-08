package com.lisitsin.configuration;

import com.lisitsin.myAnnotations.DBService;
import com.lisitsin.myAnnotations.InjectProperty;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;


public class DBServiceAnnotationObjectConfigrator implements ObjectConfigurator{

    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(DBService.class)){
                field.setAccessible(true);
                String cLassName = field.getAnnotation(DBService.class).value();
                Object object = ObjectFactory.getInstance().createObject(Class.forName(cLassName));
                field.set(t, object);
            }
        }
    }
}
