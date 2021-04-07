package com.epam.jwd.lectures.model;

public class Anesthetist implements Doctor {

    private final Doctor doctor;

    public Anesthetist(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String getName() {
        return doctor.getName();
    }

    @Override
    public DoctorType getType() {
        return doctor.getType();
    }

    @Override
    public License showLicense() {
        return doctor.showLicense();
    }

    @Override
    public void healPatient(Patient patient) {
        System.out.println("Anesthesia for patient");
        doctor.healPatient(patient);
    }
}
