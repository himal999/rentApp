package lk.rent.app.controller;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.DriverDTO;
import lk.rent.app.service.DriverService;
import lk.rent.app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("driver")
@CrossOrigin
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping(path = "/newDriver", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil newDriver(@RequestBody DriverDTO driverDTO) {
        driverService.addDriver(driverDTO);
        return new ResponseUtil(200, "success", null);
    }

    @GetMapping(path = "/allDriver", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDriver() {

        return new ResponseUtil(200, "success", driverService.getDriver());
    }

    @PutMapping(path = "/updateDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO driverDTO) {
        driverService.updateDriver(driverDTO);
        return new ResponseUtil(200, "success", driverService.findDriver(driverDTO.getLicenseNo()));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@PathVariable("id") String id) {
        driverService.deleteDriver(id);
        return new ResponseUtil(200, "success", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findDriver(@PathVariable("id") String id) {
        return new ResponseUtil(200, "success", driverService.findDriver(id));
    }
}
