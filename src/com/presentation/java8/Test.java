package com.presentation.java8;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

public class Test {
    public static void main(String[] args) {
        List<User> l = new ArrayList<>();
        l.add(new User(null,null));
        l.add(null);
        l.stream().map(User::getName).forEach(
                System.out::println
        );

    }
}


