package com.epam.jwd.lectures.validator;

import com.epam.jwd.lectures.model.Anesthetist;
import com.epam.jwd.lectures.model.Doctor;
import com.epam.jwd.lectures.model.License;

public class AnesthetistDoctorPostProcessor implements DoctorPostProcessor {
    @Override
    public Doctor process(Doctor doctor) {
        System.out.println("post process");
        if (License.GENERAL.equals(doctor.showLicense())) {
            return new Anesthetist(doctor);
        }
        return doctor;
    }
}
