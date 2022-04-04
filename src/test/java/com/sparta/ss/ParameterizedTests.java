package com.sparta.ss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.util.stream.Stream;

public class ParameterizedTests {

    @ParameterizedTest(name = "[{index}] Testing for value = {arguments}")
    @ValueSource(ints = {2,0,1,2,12,6,7})
    void checkIdLessThanTen(int number) {
        Assertions.assertTrue(number < 10);
    }

    @ParameterizedTest
    @NullAndEmptySource
//    @CsvSource({"Manish", "Neil"})
    @CsvFileSource(resources = "/names.csv")
    void CsvSourceTest(String name) {
        Assertions.assertEquals(8, name.length());
    }

    @ParameterizedTest
    @MethodSource()
    void checkLengthOfString(int length, String word) {
        Assertions.assertEquals(length, word.length());
    }

    public static Stream<Arguments> checkLengthOfString() {
        return Stream.of(
                Arguments.arguments(1, "a"),
                Arguments.arguments(3, "door"),
                Arguments.arguments(10, "house")
        );
    }

    @ParameterizedTest
    @MethodSource()
    void checkTheNameOfSpartan(Spartan spartan) {
        System.out.println(spartan.getName());
    }

    public static Stream<Spartan> checkTheNameOfSpartan() {
        return Stream.of(
                new Spartan(1, "Manish", "Java", LocalDate.now()),
                new Spartan(2, "Manish", "Java", LocalDate.now()),
                new Spartan(3, "Manish", "Java", LocalDate.now()),
                new Spartan(4, "Manish", "Java", LocalDate.now())
        );
    }


}
