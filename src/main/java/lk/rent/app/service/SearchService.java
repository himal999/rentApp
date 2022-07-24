package lk.rent.app.service;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.SearchDTO;
import lk.rent.app.dto.VehicleDTO;

import java.util.List;

public interface SearchService {
    List<VehicleDTO> findAvailableVehicle(SearchDTO searchDTO);
}
