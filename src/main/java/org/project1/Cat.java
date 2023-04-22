package org.project1;

public class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "cat";
    }
}

