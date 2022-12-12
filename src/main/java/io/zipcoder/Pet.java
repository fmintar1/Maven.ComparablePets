package io.zipcoder;

import java.util.Comparator;

public class Pet implements Comparable<Pet>, Comparator<Pet> {
    String name;
    Pet() {

    }
    String speak() {
        return "null";
    }
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    String getPetClasses() {
        return this.getClass().getSimpleName();
    }
    public int compareTo(Pet o) {
        return this.compareTo(o);
    }
    public int compare(Pet o, Pet o2) {
        return o.compareTo(o2);
    }
}
