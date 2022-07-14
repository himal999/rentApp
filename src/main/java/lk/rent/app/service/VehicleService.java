package lk.rent.app.service;/*
author :Himal
version : 0.0.1
*/


import lk.rent.app.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void addVehicle(VehicleDTO vehicleDTO);
    void updateVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getVehicle();
    void deleteVehicle(String id);
    VehicleDTO findVehicle(String id);
}
