package lk.rent.app.controller;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.LicenseDTO;
import lk.rent.app.service.LicenseService;
import lk.rent.app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("license")
@CrossOrigin
public class LicenseController {
    @Autowired
    LicenseService licenseService;


    @GetMapping(path = "/allLicense", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllLicense() {
        return new ResponseUtil(200, "success", licenseService.getLicense());
    }

    @PutMapping(path = "/updateDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateLicense(@RequestBody LicenseDTO licenseDTO) {
        licenseService.updateLicense(licenseDTO);
        return new ResponseUtil(200, "success", licenseService.findLicense(licenseDTO.getRenewId()));
    }


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findLicense(@PathVariable("id") String id) {
        return new ResponseUtil(200, "success", licenseService.findLicense(id));
    }
}
