package com.sparta.ss.mocking;

import com.sparta.ss.Spartan;
import com.sparta.ss.SpartanRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockingTest {
    private Spartan mockSpartan;

    @BeforeEach
    void setup() {
        mockSpartan = Mockito.mock(Spartan.class);
    }

    @Test
    @DisplayName("Using Mock Methods")
    void usingMockMethods() {
//        System.out.println(mockSpartan.getClass());
        SpartanRepository.addSpartan(mockSpartan);
        Mockito.when(mockSpartan.toString()).thenReturn("Found the mock");
//        System.out.println(mockSpartan.toString());
        assertEquals("Found the mock" + "\n", SpartanRepository.getAllSpartans());
    }

    @Test
    @DisplayName("Mock method chaining")
    void mockMethodChaining() {
        Mockito.when(mockSpartan.getStartDate())
                .thenReturn(LocalDate.now())
                .thenReturn(LocalDate.MAX);

        System.out.println(mockSpartan.getStartDate());
        System.out.println(mockSpartan.getStartDate());
    }
}
