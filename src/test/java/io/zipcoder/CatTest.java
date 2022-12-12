package io.zipcoder;

import org.junit.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void catInstanceTest() {
        Cat cat = new Cat();
        assertTrue(cat instanceof Pet);
    }

    @Test
    public void catNameTest() {
        Cat cat = new Cat("Oreo");
        assertEquals(cat.getName(), "Oreo");
        cat.setName("Tiger");
        assertEquals(cat.getName(), "Tiger");
    }

    @Test
    public void catSpeakTest() {
        Cat cat = new Cat();
        assertEquals(cat.speak(),"Meow!");
    }

    @Test
    public void comparableTest() {
        Cat cat = new Cat("Oreo");
        Cat cat2 = new Cat("Waffle");
        Cat cat3 = new Cat("Abaddon");

        int expected = cat.getName().compareTo(cat2.getName());
        assertTrue(String.valueOf(expected), expected < 0 );
        expected = cat.getName().compareTo(cat3.getName());
        assertTrue(String.valueOf(expected), expected > 0 );
        expected = cat2.getName().compareTo(cat3.getName());
        assertTrue(String.valueOf(expected), expected > 0);
    }

    @Test
    public void sortTest() {
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Oreo"));
        catList.add(new Cat("Waffle"));
        catList.add(new Cat("Abaddon"));
        catList.add(new Cat("Tiger"));
        catList.add(new Cat("Simba"));

        Collections.sort(catList, Comparator.comparing(Cat::getName));
        String expected = catList.stream().map(Pet::getName).collect(Collectors.joining(", "));
        
        assertEquals(catList.get(0).getName(), "Abaddon");
        assertEquals(catList.get(4).getName(), "Waffle");
        assertEquals(expected, "Abaddon, Oreo, Simba, Tiger, Waffle");
    }

}