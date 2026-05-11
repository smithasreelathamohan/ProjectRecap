package com.example.projectrecap;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class CalculatorTestData {

    public static Stream<Arguments> additionData() {
        return Stream.of(Arguments.of(10,15,25),
                Arguments.of(-7,-60,-67),
                Arguments.of(6,-50,-43),
                Arguments.of(5.777,8.5,14.277000000000001));
    }

    public static Stream<Arguments> subtractionData() {
        return Stream.of(Arguments.of(10,5,5),
                Arguments.of(30,-7,37),
                Arguments.of(-10,-20,10),
                Arguments.of(3,2,1));
    }

}
