package lk.rent.app.service;/*
author :Himal
version : 0.0.1
*/


import lk.rent.app.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void addDriver(DriverDTO driverDTO);
    void updateDriver(DriverDTO driverDTO);
    List<DriverDTO> getDriver();
    void deleteDriver(String id);
    DriverDTO findDriver(String id);
}
