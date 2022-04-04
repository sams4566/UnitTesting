package com.sparta.ss;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        SpartanRepository.addSpartan(new Spartan(1,"Manish", "Java", LocalDate.now()));
        Optional<Spartan> foundSpartan = SpartanRepository.findSpartan(1);
//        if (foundSpartan.isPresent()) { // if (spartan != null)
//            System.out.println(foundSpartan.get());
//        } else {
//            System.out.println("No spartan found");
//        }
//        foundSpartan.isPresent()
    }
}
