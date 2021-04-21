package com.epam.jwd.lectures.model;

public class Anesthetist extends DoctorAdditionalSpeciality {

    public Anesthetist(Doctor doctor) {
        super(doctor);
    }

    @Override
    public void healPatient(Patient patient) {
        System.out.println("Anesthesia for patient");
        doctor.healPatient(patient);
    }
}
