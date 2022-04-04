package com.sparta.ss.mocking;

import com.sparta.ss.Spartan;
import com.sparta.ss.SpartanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SpartanRepositoryTestsTask {
    private Spartan fakeSpartan;
    private Spartan realSpartan;
    private Spartan realSpartan2;
    private Spartan realSpartan3;
    private Spartan spySpartan;
    private Spartan spySpartan2;
    private Spartan spySpartan3;

    @BeforeEach
    void setup() {
        fakeSpartan = Mockito.mock(Spartan.class);
        realSpartan = new Spartan(1, "Brian", "Java", LocalDate.of(2022, 3, 3));
        realSpartan2 = new Spartan(2, "Brian", "Java", LocalDate.of(2022, 3, 3));
        realSpartan3 = new Spartan(3, "Brian", "Java", LocalDate.of(2022, 3, 3));
        spySpartan = Mockito.spy(realSpartan);
        spySpartan2 = Mockito.spy(realSpartan2);
        spySpartan3 = Mockito.spy(realSpartan3);
    }

//    @Test
//    @DisplayName("Verify findSpartan1")
//    void verifyFindSpartan1() {
//        SpartanRepository.addSpartan(fakeSpartan);
//        assertFalse(SpartanRepository.findSpartan(1).isPresent());
//    }

    @Test
    @DisplayName("Verify findSpartan2")
    void verifyFindSpartan2() {
        SpartanRepository.addSpartan(spySpartan);
        assertTrue(SpartanRepository.findSpartan(1).isPresent());
    }

    @Test
    @DisplayName("Verify spartan removed")
    void verifySpartanRemoved() {
        SpartanRepository.addSpartan(fakeSpartan);
        assertTrue(SpartanRepository.removeSpartan(fakeSpartan.getId()));
    }

    @Test
    @DisplayName("Verify getAllSpartans")
    void verifyGetAllSpartans() {
        String spartan = spySpartan.toString();
        SpartanRepository.addSpartan(spySpartan);
        String returnedSpartan = SpartanRepository.getAllSpartans();
        assertEquals(spartan + "\n", returnedSpartan);
    }

    @Test
    @DisplayName("Verify only correct ID is deleted")
    void verifyOnlyCorrectIdIsDeleted() {
        SpartanRepository.addSpartan(spySpartan);
        SpartanRepository.addSpartan(spySpartan2);
        SpartanRepository.addSpartan(spySpartan3);
        SpartanRepository.removeSpartan(spySpartan.getId());
        assertTrue(!SpartanRepository.findSpartan(spySpartan.getId()).isPresent());
    }

    @Test
    @DisplayName("Check toString method")
    void checkToStringMethod() {
        SpartanRepository.addSpartan(fakeSpartan);
        Mockito.when(fakeSpartan.toString()).thenReturn("String returned correctly");
        assertEquals("String returned correctly" + "\n", SpartanRepository.getAllSpartans());
    }
}
