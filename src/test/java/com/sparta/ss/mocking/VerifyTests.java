package com.sparta.ss.mocking;

import com.sparta.ss.Spartan;
import com.sparta.ss.SpartanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.time.LocalDate;

public class VerifyTests {
    private Spartan fakeSpartan;
    private Spartan realSpartan;
    private Spartan spySpartan;

    @BeforeEach
    void setup() {
        fakeSpartan = Mockito.mock(Spartan.class);
        realSpartan = new Spartan(2, "Neil", "Java", LocalDate.of(1999,1,1));
        spySpartan = Mockito.spy(realSpartan);
    }

    @Test
    @DisplayName("Verify a mock method")
    void verifyAMockMethod() {
        SpartanRepository.addSpartan(fakeSpartan);
        Mockito.when(fakeSpartan.toString()).thenReturn("Found the fake");
        System.out.println(SpartanRepository.getAllSpartans());
        System.out.println(SpartanRepository.findSpartan(1).isPresent());
        Mockito.verify(fakeSpartan, Mockito.times(1)).getId();
    }

    @Test
    @DisplayName("Verify order of operations")
    void verifyOrderOfOperations() {
        spySpartan.setName("Manish");
        spySpartan.setCourse("Data");
        System.out.println("Name: " + spySpartan.getName() + "\n" + "Course: " + spySpartan.getCourse());

        InOrder inOrder = Mockito.inOrder(spySpartan);
        inOrder.verify(spySpartan).setName("Manish");
//        inOrder.verify(spySpartan).setCourse("Data");
        inOrder.verify(spySpartan).getName();
        inOrder.verify(spySpartan).getCourse();
    }
}
