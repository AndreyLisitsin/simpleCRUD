package com.lisitsin.configuration;

import com.lisitsin.repositories.GenericRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLLabelRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLPostAndLabelsRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLWriterRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQlPostRepository;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectFactory {

    private static ObjectFactory instance = new ObjectFactory();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Config config;

    @SneakyThrows
    private ObjectFactory(){
        config = new JavaConfig("com.lisitsin", new HashMap<>(Map.of(GenericRepository.class, MySQLPostAndLabelsRepository.class)));
        for (Class<? extends ObjectConfigurator> aClass : config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    public static ObjectFactory getInstance (){
        return instance;
    }

    @SneakyThrows
    public  <T> T createObject(Class<T> type){
        Class<? extends T> implClass = type;
        if (type.isInterface()){
            implClass = config.getImplClass(type);
        }

        T t = implClass.getDeclaredConstructor().newInstance();

        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t));

        return t;
    }
}
