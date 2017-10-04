package com.presentation.java8;

import java.util.List;

/**
 * Created by ono on 11.06.2017.
 */
public class A {

    public A(List<B> b) {
        this.b = b;
    }

    private List<B> b;

    public List<B> getB() {
        return b;
    }
}
