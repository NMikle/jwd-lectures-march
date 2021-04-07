package com.epam.jwd.lectures.validator;

import com.epam.jwd.lectures.model.DoctorType;
import com.epam.jwd.lectures.model.License;

public interface DoctorPreProcessor {
    boolean valid(DoctorType doctorType, License licenseType);

    static DoctorPreProcessor newInstance() {
        return DoctorLicenseValidator.INSTANCE;
    }
}
