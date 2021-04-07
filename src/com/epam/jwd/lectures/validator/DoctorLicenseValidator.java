package com.epam.jwd.lectures.validator;

import com.epam.jwd.lectures.model.DoctorType;
import com.epam.jwd.lectures.model.License;

public enum DoctorLicenseValidator implements DoctorPreProcessor {
    INSTANCE;

    @Override
    public boolean valid(DoctorType doctorType, License licenseType) {
        System.out.println("pre process");
        switch (doctorType) {
            case NURSE:
                if (licenseType != null) {
                    System.out.println("license all right");
                    return true;
                }
            case PEDIATRICIAN:
                if (License.GENERAL.equals(licenseType)) {
                    System.out.println("license all right");
                    return true;
                }
        }
        System.out.println("license issues");
        return false;
    }
}
