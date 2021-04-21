package com.epam.jwd.lectures.model;

import java.util.Objects;

public abstract class DoctorAdditionalSpeciality implements Doctor {

    protected final Doctor doctor;

    public DoctorAdditionalSpeciality(Doctor doctor) {
        Objects.requireNonNull(doctor);
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

}
