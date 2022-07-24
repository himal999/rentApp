package lk.rent.app.service.impl;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.VehicleDTO;
import lk.rent.app.entity.Vehicle;
import lk.rent.app.repo.VehicleRepo;
import lk.rent.app.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;
    @Autowired
    ModelMapper mapper;


    public void addVehicle(VehicleDTO vehicleDTO) {
        if(!vehicleRepo.existsById(vehicleDTO.getVehicleNo())){
            vehicleRepo.save(mapper.map(vehicleDTO,Vehicle.class));
        }else{
            throw new RuntimeException("Vehicle "+vehicleDTO.getVehicleNo()+" Already Exists !!!");
        }
    }

    public void updateVehicle(VehicleDTO vehicleDTO) {
        if(vehicleRepo.existsById(vehicleDTO.getVehicleNo())){
            vehicleRepo.save(mapper.map(vehicleDTO,Vehicle.class));
        }else{
            throw new RuntimeException("Vehicle "+vehicleDTO.getVehicleNo()+" Not Register yet !!!");
        }
    }

    public List<VehicleDTO> getVehicle() {
        return mapper.map(vehicleRepo.findAll(),new TypeToken<List<VehicleDTO>>(){}.getType());
    }

    public void deleteVehicle(String id) {
        if(vehicleRepo.existsById(id)){
            vehicleRepo.deleteById((id));
        }else{
            throw new RuntimeException("Can't remove Vehicle,Please not Register Vehicle yet!!!");
        }
    }

    public VehicleDTO findVehicle(String id) {
        if(vehicleRepo.existsById(id)){
          return mapper.map(vehicleRepo.findById((id)),VehicleDTO.class);
        }else{
            throw new RuntimeException("Can't find Vehicle,Please not Register Vehicle yet!!!");
        }

    }
}
