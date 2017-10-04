package com.presentation.java8.stream.incorrect;

import com.presentation.java8.Annotations.Bad;

import java.util.stream.IntStream;

public class ForgotTerminalOperation {
    @Bad
    public void willDoNothingInReality() {
        IntStream.range(1, 5)
                .peek(System.out::println)
                .peek(i -> {
                    if (i == 5)
                        throw new RuntimeException("bang");
                });
    }
}