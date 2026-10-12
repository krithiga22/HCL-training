package com.alumniportal.strategy;

import com.alumniportal.model.AlumniProfile;

public interface PrivacyFilterStrategy {

    AlumniProfile filterProfile(AlumniProfile profile);
}