package com.epam.jwd.lectures.validator;

import com.epam.jwd.lectures.exception.PreProcessorException;
import com.epam.jwd.lectures.model.Doctor;
import com.epam.jwd.lectures.model.DoctorType;
import com.epam.jwd.lectures.model.DoctorsUniversity;
import com.epam.jwd.lectures.model.License;

public class UniversityPreProcessingDecorator implements DoctorsUniversity {

    private final DoctorPreProcessor preProcessor = DoctorPreProcessor.newInstance();

    private final DoctorsUniversity university;

    public UniversityPreProcessingDecorator(DoctorsUniversity university) {
        this.university = university;
    }

    @Override
    public Doctor newDoctor(DoctorType type, String name, License license) throws PreProcessorException {
        System.out.println("Running PreProcessors");
        if (!preProcessor.valid(type, license)) {
            throw new PreProcessorException("Input data not valid");
        }
        return university.newDoctor(type, name, license);
    }

    @Override
    public License newLicense(String type) {
        return university.newLicense(type);
    }
}
