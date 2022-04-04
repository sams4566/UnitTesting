package com.sparta.ss.mocking;

import com.sparta.ss.Spartan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class SpyTests {
    private Spartan realSpartan;
    private Spartan spySpartan;

    @BeforeEach
    void setup() {
        realSpartan = new Spartan(2,"Neil", "Java", LocalDate.of(1999, 1,1));
        spySpartan = Mockito.spy(realSpartan);
    }

    @Test
    @DisplayName("Using a spy")
    void usingASpy() {
        Mockito.when(spySpartan.getCourse())
                .thenCallRealMethod()
                .thenReturn("Spy course name");
        System.out.println(spySpartan.getCourse());
        System.out.println(spySpartan.getCourse());
    }
}
