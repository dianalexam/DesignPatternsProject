package org.project1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VaccinationReminder implements Subject {

    private List<Observer> observers;
    private Pet pet;

    private LocalDate lastVaccinationDate;

    public VaccinationReminder(Pet pet, LocalDate lastVaccinationDate) {
        observers = new ArrayList<>();
        this.pet = pet;
        this.lastVaccinationDate = lastVaccinationDate;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(pet);
        }
    }

    public void enterPetVaccination(Pet pet, LocalDate lastVaccinationDate) {
        this.pet = pet;
        this.lastVaccinationDate = lastVaccinationDate;
    }

    public LocalDate getLastVaccinationDate() {
        return lastVaccinationDate;
    }

    public void checkIfReminderIsNeeded() {
        LocalDate currentDate = LocalDate.now();

        if (LocalDate.now().isAfter(lastVaccinationDate.plusYears(1))) {
            notifyObservers();
        }
    }

}
