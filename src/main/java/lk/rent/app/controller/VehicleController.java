package lk.rent.app.controller;/*
author :Himal
version : 0.0.1
*/


import lk.rent.app.dto.VehicleDTO;
import lk.rent.app.service.VehicleService;
import lk.rent.app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @PostMapping(path = "/newVehicle", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil newVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.addVehicle(vehicleDTO);
        return new ResponseUtil(200, "success", null);
    }

    @GetMapping(path = "/allVehicle", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicle() {
        return new ResponseUtil(200, "success", vehicleService.getVehicle());
    }

    @PutMapping(path = "/updateDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.updateVehicle(vehicleDTO);
        return new ResponseUtil(200, "success", vehicleService.findVehicle(vehicleDTO.getVehicleNo()));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicle(@PathVariable("id") String id) {
        vehicleService.deleteVehicle(id);
        return new ResponseUtil(200, "success", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findVehicle(@PathVariable("id") String id) {
        return new ResponseUtil(200, "success", vehicleService.findVehicle(id));
    }
}
