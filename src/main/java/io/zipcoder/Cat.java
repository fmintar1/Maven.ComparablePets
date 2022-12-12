package io.zipcoder;

public class Cat extends Pet {
    Cat() {
    }
    Cat(String name) {
        super.name = name;
    }
    String speak() {
        return "Meow!";
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
