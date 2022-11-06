package com.lisitsin.configuration;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc);
}
