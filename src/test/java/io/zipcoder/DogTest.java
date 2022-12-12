package io.zipcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DogTest {
    @Test
    public void dogInstanceTest() {
        Dog dog = new Dog();
        assertTrue(dog instanceof Pet);
    }

    @Test
    public void dogNameTest() {
        Dog dog = new Dog("Zoro");
        assertEquals(dog.getName(), "Zoro");
        dog.setName("Aaron");
        assertEquals(dog.getName(), "Aaron");
    }

    @Test
    public void dogSpeakTest() {
        Dog dog = new Dog();
        assertEquals(dog.speak(),"Bark!");
    }

    @Test
    public void comparableTest() {
        Dog dog = new Dog("Aaron");
        Dog dog2 = new Dog("Zoro");
        Dog dog3 = new Dog("Skull");

        int expected = dog.getName().compareTo(dog2.getName());
        assertTrue(String.valueOf(expected), expected < 0 );
        expected = dog.getName().compareTo(dog3.getName());
        assertTrue(String.valueOf(expected), expected < 0 );
        expected = dog2.getName().compareTo(dog3.getName());
        assertTrue(String.valueOf(expected), expected > 0);
    }

    @Test
    public void sortTest() {
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog("Skull"));
        dogList.add(new Dog("Buddy"));
        dogList.add(new Dog("Zoro"));
        dogList.add(new Dog("Ishizu"));
        dogList.add(new Dog("Aaron"));

        Collections.sort(dogList, Comparator.comparing(Dog::getName));
        String expected = dogList.stream().map(Pet::getName).collect(Collectors.joining(", "));

        assertEquals(dogList.get(0).getName(), "Aaron");
        assertEquals(dogList.get(4).getName(), "Zoro");
        assertEquals(expected, "Aaron, Buddy, Ishizu, Skull, Zoro");
    }

}