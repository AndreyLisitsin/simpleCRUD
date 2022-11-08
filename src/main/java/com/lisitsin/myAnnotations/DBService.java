package com.lisitsin.myAnnotations;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DBService {

    String value() default "" ;
}
