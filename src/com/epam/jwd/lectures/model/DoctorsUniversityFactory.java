package com.epam.jwd.lectures.model;

public enum DoctorsUniversityFactory implements DoctorsUniversity {
    INSTANCE;

    public Doctor newDoctor(DoctorType type, String name, License license) {
        System.out.println("Creating doctor");
        final Doctor doctor;
        switch (type) {
            case PEDIATRICIAN:
                doctor = new Pediatrician(name, license);
                break;
            case NURSE:
                doctor = new Nurse(name, license);
                break;
            default:
                throw new IllegalArgumentException("Doctor type not found " + type.name());
        }
        return doctor;
    }

    @Override
    public License newLicense(String type) {
        return License.valueOf(type.toUpperCase());
    }
}
