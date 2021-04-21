package com.epam.jwd.lectures.model;

import com.epam.jwd.lectures.exception.PreProcessorException;
import com.epam.jwd.lectures.validator.UniversityPostProcessingDecorator;
import com.epam.jwd.lectures.validator.UniversityPreProcessingDecorator;

public interface DoctorsUniversity {

    Doctor newDoctor(DoctorType type, String name, License license) throws PreProcessorException;

    License newLicense(String type);

    static DoctorsUniversity newInstance() {
        return new UniversityPostProcessingDecorator(
                new UniversityPreProcessingDecorator(
                        DoctorsUniversityFactory.INSTANCE
                )
        );
    }

}
