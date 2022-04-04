package com.sparta.ss;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpartanTests {
    private Spartan manish;

    //Hooks - BeforeAll, BeforeEach, AfterAll, AfterEach - "setup, tearDown"

    @BeforeAll
    static void setupAll(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " has started");
    }

    @BeforeEach
    void setup(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " is running");
        manish = new Spartan(1, "Manish", "Java", LocalDate.of(2022, 4, 4));
    }

    @Nested
    @DisplayName("Date Tests")
    class DateTests {
        @Tag("DateTest")
        @Test
        @DisplayName("Check if start date is today")
        void checkIfStartDateIsToday() {
            assertEquals(LocalDate.now(), manish.getStartDate());
        }
    }

    @DisabledOnOs(OS.LINUX) //Don't run the test on Linux machienes
    @Test
    @DisplayName("SimpleTest")
    void simpleTest() {
        Assumptions.assumeTrue( manish == null);
        assertEquals("Manish", manish.getName());
    }

    @AfterAll
    static void tearDownAll(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " has finished");
    }
}
