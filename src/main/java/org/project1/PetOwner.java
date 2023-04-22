package org.project1;

import java.util.ArrayList;
import java.util.List;

public class PetOwner implements Observer {

    private String name;
    private List<Pet> pets;

    public PetOwner(String name) {
        this.name = name;
        this.pets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Pet pet) {
        System.out.println(
                "Dear " + getName() + ", "
                        + "vaccination renewal is needed for your "
                        + pet.getType() + ": " + pet.getName()
        );
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }
}
