package com.epam.jwd.lectures.model;

public interface Doctor {

    String getName();

    DoctorType getType();

    License showLicense();

    void healPatient(Patient patient);

}
