package com.epam.jwd.lectures.model;

public abstract class AbstractDoctor implements Doctor {

    private final String name;
    private final DoctorType type;
    private final License license;

    protected AbstractDoctor(String name, DoctorType type, License license) {
        this.name = name;
        this.type = type;
        this.license = license;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DoctorType getType() {
        return type;
    }

    @Override
    public License showLicense() {
        return license;
    }
}
