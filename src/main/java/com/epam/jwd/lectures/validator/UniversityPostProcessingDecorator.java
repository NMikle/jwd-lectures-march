package com.epam.jwd.lectures.validator;

import com.epam.jwd.lectures.exception.PreProcessorException;
import com.epam.jwd.lectures.model.Doctor;
import com.epam.jwd.lectures.model.DoctorType;
import com.epam.jwd.lectures.model.DoctorsUniversity;
import com.epam.jwd.lectures.model.License;

public class UniversityPostProcessingDecorator implements DoctorsUniversity {

    private final DoctorPostProcessor postProcessor = new AnesthetistDoctorPostProcessor();

    private final DoctorsUniversity university;

    public UniversityPostProcessingDecorator(DoctorsUniversity university) {
        this.university = university;
    }

    @Override
    public Doctor newDoctor(DoctorType type, String name, License license) throws PreProcessorException {
        Doctor doctor = university.newDoctor(type, name, license);
        System.out.println("Running PostProcessors");
        doctor = postProcessor.process(doctor);
        return doctor;
    }

    @Override
    public License newLicense(String type) {
        return university.newLicense(type);
    }
}
