package io.zipcoder;

public class Dog extends Pet {
    Dog() {
    }
    Dog(String name) {
        super.name = name;
    }
    String speak() {
        return "Bark!";
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
