package io.zipcoder;

public class Pig extends Pet{
    Pig() {
    }
    Pig(String name) {
        super.name = name;
    }
    String speak() {
        return "Oink!";
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
