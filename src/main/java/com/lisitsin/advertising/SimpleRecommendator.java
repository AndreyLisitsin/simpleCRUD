package com.lisitsin.advertising;

import com.lisitsin.myAnnotations.InjectProperty;

public class SimpleRecommendator implements Recommendator {

    @InjectProperty
    String developmentEnvironment;

    @Override
    public void recommend() {
        System.out.println("If you want to code faster, use " + developmentEnvironment);
    }
}
