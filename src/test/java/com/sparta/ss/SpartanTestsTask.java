package com.sparta.ss;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestsTask {
    private Spartan brian;

    @BeforeAll
    static void setupAll(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " has started");
    }

    @BeforeEach
    void setup(TestInfo testInfo) {
        brian = new Spartan(1, "Brian", "Java", LocalDate.of(2022, 3, 3));
    }

    @AfterAll
    static void tearDownAll(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " has finished");
    }

    @Test
    @DisplayName("Check class is correct type")
    void checkClassIsCorrectType() {
        assertEquals(String.valueOf(brian.getStartDate().getClass()), "class java.time.LocalDate");
    }
    
    @Test
    @DisplayName("Check if there is special characters in string")
    void checkIfThereIsSpecialCharactersInString() {
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecialCharacter = special.matcher(brian.getName());
        assertTrue(!hasSpecialCharacter.find());
    }

    @Test
    @DisplayName("Check if date is in the future")
    void checkIfDateIsInTheFuture() {
        assertTrue(brian.getStartDate().isBefore(LocalDate.now()));
    }

    @Test
    @DisplayName("Check if negative number")
    void checkIfNegativeNumber() {
        assertTrue(brian.getId() >= 1);
    }

    @Test
    @DisplayName("Check name is correct")
    void checkNameIsCorrect() {
        assertThat(brian, hasProperty("name", equalTo("Brian")));
    }

    @ParameterizedTest
    @MethodSource()
    void checkCourseOfSpartan(Spartan spartan) {
        System.out.println(spartan.getCourse());
    }

    public static Stream<Spartan> checkCourseOfSpartan() {
        return Stream.of(
                new Spartan(2, "Henry", "Data", LocalDate.now()),
                new Spartan(3, "Gerald", "C#", LocalDate.now()),
                new Spartan(4, "Fred", "DevOps", LocalDate.now())
        );
    }

    @Test
    @DisplayName("Check name length is greater than 1")
    void checkNameLengthIsGreaterThan1() {
       assertTrue(brian.getName().length() > 0);
    }

    @Test
    @DisplayName("Check if string is null")
    void checkIfStringIsNull() {
        assertTrue(brian.getName() != null);
    }

    @ParameterizedTest
    @DisplayName("Check input string exception")
    @ValueSource(strings = {"a"})
    void checkInputStringException(String x) {
        assertThrows(NumberFormatException.class, () -> brian.setId(Integer.parseInt(x)));
    }

    @Test
    @DisplayName("Check if startTime setter works")
    void checkIfStartTimeSetterWorks() {
        brian.setStartDate(LocalDate.now());
        assertEquals(LocalDate.now(), brian.getStartDate());
    }

    @Test
    @DisplayName("Check the spelling of the name")
    void checkTheSpellingOfTheName() {
        assertThat(brian.getName(), endsWith("ian"));
    }
}