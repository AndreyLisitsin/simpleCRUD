package com.lisitsin;

import com.lisitsin.configuration.ObjectFactory;

public class Main {
    public static void main(String[] args){

    ApplicationRunner runner = ObjectFactory.getInstance().createObject(ApplicationRunner.class);
    runner.start();

    }
}