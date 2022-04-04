package com.sparta.ss;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HamcrestTests {

    private Spartan manish;

    @BeforeEach
    void setup(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + " is running");
        manish = new Spartan(1, "Manish", "Java", LocalDate.of(2022, 4, 4));
    }

    @Test
    @DisplayName("Testing with Hamcrest")
    void testingWithHamcrest() {
//        assertThat(manish.getName(), equalTo("Manish"));
        assertThat(manish.getName(), endsWith("ish"));
    }

    @Test
    @DisplayName("Check that spartan has a property called name")
    void checkThatSpartanHasAPropertyCalledName() {
        assertThat(manish, hasProperty("name", equalTo("Manish")));
    }
}
