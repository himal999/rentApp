package lk.rent.app.service.impl;/*
author :Himal
version : 0.0.1
*/


import lk.rent.app.dto.DriverDTO;
import lk.rent.app.entity.Driver;
import lk.rent.app.repo.DriverRepo;
import lk.rent.app.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addDriver(DriverDTO driverDTO) {
            if(!driverRepo.existsById(driverDTO.getLicenseNo())){
                driverRepo.save(mapper.map(driverDTO, Driver.class));
            }else{
                throw new RuntimeException("Driver "+driverDTO.getLicenseNo()+" Already Exists !!!");
            }
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        if(driverRepo.existsById(driverDTO.getLicenseNo())){
            driverRepo.save(mapper.map(driverDTO, Driver.class));
        }else{
            throw new RuntimeException("Please Register first !!!");
        }
    }

    @Override
    public List<DriverDTO> getDriver() {
       return mapper.map(driverRepo.findAll(),new TypeToken<List<DriverDTO>>(){}.getType());
    }

    @Override
    public void deleteDriver(String id) {
        if(driverRepo.existsById(id)){
            driverRepo.deleteById(id);
        }else{
            throw new RuntimeException("Can't remove Driver,Please not Register Driver yet!!!");
        }
    }

    @Override
    public DriverDTO findDriver(String id) {
        if(driverRepo.existsById(id)){
            return mapper.map(driverRepo.findById(id), DriverDTO.class);
        }else{
            throw new RuntimeException("Can't find Driver,Please not Register Driver yet!!!");
        }
    }
}
