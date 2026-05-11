package com.example.projectrecap;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator calc;
    private static final Logger log = Logger.getLogger(CalculatorTest.class.getName());

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @AfterEach
    void tearDown() {
        log.info("-------test finished--------");
    }

    @ParameterizedTest(name = "Add {0} + {1} ")
    @MethodSource("com.example.projectrecap.CalculatorTestData#additionData")
    void addTest(double a, double b, double expected) {
        double result = calc.add(a, b);
        assertEquals(expected, result, "\nFailed: " + a + " + " + b + " should be = " + expected
                + " but actual result calculated is " + result);
        log.info(a + "+" + b + " should be = " + expected);

    }

    @ParameterizedTest(name = "Sub {0} - {1} ")
    @MethodSource("com.example.projectrecap.CalculatorTestData#subtractionData")
    void subTest(double a, double b, double expected) {
        double result = calc.subtract(a, b);
        assertEquals(expected, result, "\nFailed: " + a + " - " + b + " should be = " + expected
                + " but actual result calculated is " + result);
        log.info(a + "-" + b + " should be = " + expected);

    }

    @Test
    @DisplayName("MultiplicationTest")
    void multiplyTest() {
        int result = calc.multiply(1, 2);
        assertEquals(2, result, "Multiplication failed");
    }

    @ParameterizedTest(name = "Add {0} + {1} ")
    @CsvSource({
            "10,2,5",
            "20,4,5",
            "9,3,3"
    })
    void divideTest(int a, int b, int expected) {
        int result = calc.divide(a, b);
        assertEquals(expected, result, "division failed");

    }
}