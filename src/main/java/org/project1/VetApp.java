package org.project1;

import java.time.LocalDate;

public class VetApp {

    public static void main(String[] args) {

        // create an owner with a pet
        PetOwner owner1 = new PetOwner("Diana");
        Pet pet1 = new Dog("Ricky");

        // create the vaccination reminder for this pet
        VaccinationReminder reminder = new VaccinationReminder(pet1, LocalDate.now().minusMonths(13));
        reminder.registerObserver(owner1);
        reminder.checkIfReminderIsNeeded();

        // add a second owner for this pet
        PetOwner owner2 = new PetOwner("George");
        reminder.registerObserver(owner2);
        reminder.checkIfReminderIsNeeded();

        // remove first owner for this pet
        reminder.removeObserver(owner1);

        // update vaccination date & check if reminder is triggered
        reminder.enterPetVaccination(pet1, LocalDate.now());
        reminder.checkIfReminderIsNeeded();
        System.out.println(reminder.getLastVaccinationDate());

        // create a new pet (& vaccination reminder) for the first owner
        Pet pet2 = new Cat("Kitty");
        owner1.addPet(pet2);

        VaccinationReminder reminder2 = new VaccinationReminder(pet2, LocalDate.now().minusYears(2));
        reminder2.registerObserver(owner1);
        reminder2.checkIfReminderIsNeeded();


    }
}
