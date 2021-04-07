package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.exception.PreProcessorException;
import com.epam.jwd.lectures.model.Doctor;
import com.epam.jwd.lectures.model.DoctorType;
import com.epam.jwd.lectures.model.DoctorsUniversity;
import com.epam.jwd.lectures.model.License;

public class Main {

    public static void main(String[] args) {
        final DoctorsUniversity university = DoctorsUniversity.newInstance();
        final License license = university.newLicense("nurse");
        final Doctor doctor;
        try {
            doctor = university
                    .newDoctor(DoctorType.NURSE, "Alice", license);
            doctor.healPatient(null);
        } catch (PreProcessorException e) {
            System.out.println("Could not create doctor");
        }
    }

}
