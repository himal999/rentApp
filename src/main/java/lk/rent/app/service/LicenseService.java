package lk.rent.app.service;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.LicenseDTO;


import java.util.List;

public interface LicenseService {
    void updateLicense(LicenseDTO licenseDTO);
    List<LicenseDTO> getLicense();
    void deleteLicense(String id);
    LicenseDTO findLicense(String id);
}
