package com.epam.jwd.lectures.validator;

import com.epam.jwd.lectures.model.Doctor;

public interface DoctorPostProcessor {
    Doctor process(Doctor doctor);
}
