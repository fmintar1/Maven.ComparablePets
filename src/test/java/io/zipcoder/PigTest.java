package io.zipcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class PigTest {

    @Test
    public void pigInstanceTest() {
        Pig pig = new Pig();
        assertTrue(pig instanceof Pet);
    }

    @Test
    public void pigNameTest() {
        Pig pig = new Pig("Chris");
        assertEquals(pig.getName(), "Chris");
        pig.setName("Bacon");
        assertEquals(pig.getName(), "Bacon");
    }

    @Test
    public void pigSpeakTest() {
        Pig pig = new Pig();
        assertEquals(pig.speak(),"Oink!");
    }

    @Test
    public void comparableTest() {
        Pig pig = new Pig("Hawk");
        Pig pig2 = new Pig("Bacon");
        Pig pig3 = new Pig("Chris");

        int expected = pig.getName().compareTo(pig2.getName());
        assertTrue(String.valueOf(expected), expected > 0 );
        expected = pig.getName().compareTo(pig3.getName());
        assertTrue(String.valueOf(expected), expected > 0 );
        expected = pig2.getName().compareTo(pig3.getName());
        assertTrue(String.valueOf(expected), expected < 0);
    }

    @Test
    public void sortTest() {
        List<Pig> pigList = new ArrayList<>();
        pigList.add(new Pig("Chris"));
        pigList.add(new Pig("Bacon"));
        pigList.add(new Pig("Hawk"));
        pigList.add(new Pig("Zorgon"));
        pigList.add(new Pig("Xatu"));

        Collections.sort(pigList, Comparator.comparing(Pet::getName));
        String expected = pigList.stream().map(Pet::getName).collect(Collectors.joining(", "));

        assertEquals(pigList.get(0).getName(), "Bacon");
        assertEquals(pigList.get(4).getName(), "Zorgon");
        assertEquals(expected, "Bacon, Chris, Hawk, Xatu, Zorgon");
    }

}