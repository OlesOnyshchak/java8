package com.presentation.java8.stream.incorrect;

import java.util.stream.IntStream;
import com.presentation.java8.Annotations.Bad;
import com.presentation.java8.Annotations.Good;

public class InfiniteStreams {
    @Bad
    public void infinite(){
        IntStream.iterate(0, i -> i + 1)
                .forEach(System.out::println);
    }

    @Good
    public void validOne(){
        IntStream.iterate(0, i -> i + 1)
                .limit(10)
                .forEach(System.out::println);
    }

    @Bad
    public void stillInfinite(){
        IntStream.iterate(0, i -> ( i + 1 ) % 2)
                .distinct()
                .limit(10)
                .forEach(System.out::println);
    }

    @Good
    public void butThisOneIfFine(){
        IntStream.iterate(0, i -> ( i + 1 ) % 2)
                .limit(10)
                .distinct()
                .forEach(System.out::println);
    }
}