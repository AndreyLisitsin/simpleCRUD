package com.lisitsin.configuration;

import lombok.Delegate;
import lombok.Getter;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    Map<Class, Class> inc2ImplClass;


    public JavaConfig(String packageToScan, Map<Class,Class> inc2ImplClass) {
        this.inc2ImplClass = inc2ImplClass;
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return inc2ImplClass.computeIfAbsent(ifc, classes1 -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() != 1) {
                throw new RuntimeException(ifc + " has 0 or more than one impl");
            }
            return classes.iterator().next();
        });
    }
}
