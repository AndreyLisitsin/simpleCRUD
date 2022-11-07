package com.lisitsin.configuration;


public class ObjectFactory {

    private Config config  = new JavaConfig("com.lisitsin");

    private static ObjectFactory instance = new ObjectFactory();

    private ObjectFactory getInstance (){
        return instance;
    }

    private ObjectFactory(){}

    public <T> T createObject(Class<T> type){
        Class<? extends T> implClass = type;
        if (type.isInterface()){

            implClass = config.getImplClass(type);
        }




        return null;
    }
}
