package com.epam.jwd.lectures.model;

public class Nurse extends AbstractDoctor {

    Nurse(String name, License license) {
        super(name, DoctorType.NURSE, license);
    }

    @Override
    public void healPatient(Patient patient) {
        System.out.println("Nurse " + getName() + " healing patient");
    }
}
