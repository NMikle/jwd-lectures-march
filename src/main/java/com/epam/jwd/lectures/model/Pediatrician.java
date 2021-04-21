package com.epam.jwd.lectures.model;

public class Pediatrician extends AbstractDoctor {

    Pediatrician(String name, License license) {
        super(name, DoctorType.PEDIATRICIAN, license);
    }

    @Override
    public void healPatient(Patient patient) {
        System.out.println("Pediatrician " + getName() + " healing patient");
    }
}
