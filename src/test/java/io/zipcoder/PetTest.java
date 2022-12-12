package io.zipcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

public class PetTest {

    @Test
    public void sortNameTest(){
        List<Pet> petList = new ArrayList<>();
        petList.add(new Cat("Oreo"));
        petList.add(new Dog("Chief"));
        petList.add(new Pig("Hawk"));
        petList.add(new Cat("Tiger"));
        petList.add(new Dog("Skull"));
        petList.add(new Pig("Chris"));

        Collections.sort(petList, Comparator.comparing(Pet::getName));
        String expected = petList.stream().map(Pet::getName).collect(Collectors.joining(", "));
        String actual = "Chief, Chris, Hawk, Oreo, Skull, Tiger";

        assertEquals(expected, actual);
    }

    @Test
    public void sortSpeakTest(){
        List<Pet> petList = new ArrayList<>();
        petList.add(new Cat("Oreo"));
        petList.add(new Dog("Chief"));
        petList.add(new Pig("Hawk"));
        petList.add(new Cat("Tiger"));
        petList.add(new Dog("Skull"));
        petList.add(new Pig("Chris"));

        Collections.sort(petList, Comparator.comparing(Pet::speak));
        String expected = petList.stream().map(Pet::speak).collect(Collectors.joining(", "));
        String actual = "Bark!, Bark!, Meow!, Meow!, Oink!, Oink!";

        assertEquals(expected, actual);
    }

    @Test
    public void sortClassTest() {
        List<Pet> petList = new ArrayList<>();
        petList.add(new Cat("Oreo"));
        petList.add(new Dog("Chief"));
        petList.add(new Pig("Hawk"));
        petList.add(new Cat("Tiger"));
        petList.add(new Dog("Skull"));
        petList.add(new Pig("Chris"));

        Collections.sort(petList, Comparator.comparing(Pet::getPetClasses));
        String expected = petList.stream().map(Pet::getPetClasses).collect(Collectors.joining(", "));
        String actual = "Cat, Cat, Dog, Dog, Pig, Pig";

        assertEquals(expected, actual);
    }

}