package lk.rent.app.service.impl;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.LicenseDTO;
import lk.rent.app.entity.License;
import lk.rent.app.repo.LicenseRepo;
import lk.rent.app.service.LicenseService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LicenseServiceImpl implements LicenseService {

    @Autowired
    LicenseRepo licenseRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void updateLicense(LicenseDTO licenseDTO) {
            if(licenseRepo.existsById(licenseDTO.getRenewId())){
             licenseRepo.save(mapper.map(licenseDTO, License.class));
            }else{
                throw new RuntimeException("Please Register first !!!");
            }
    }

    @Override
    public List<LicenseDTO> getLicense() {
        return mapper.map(licenseRepo.findAll(), new TypeToken<List<LicenseDTO>>(){}.getType());
    }

    @Override
    public void deleteLicense(String id) {
        if(licenseRepo.existsById(id)){
            licenseRepo.deleteById(id);
        }else{
            throw new RuntimeException("Can't remove License,Please not Register License yet!!!");
        }

    }

    @Override
    public LicenseDTO findLicense(String id) {
        if(licenseRepo.existsById(id)){
            return mapper.map(licenseRepo.findById(id),LicenseDTO.class);
        }else{
            throw new RuntimeException("Can't find License,Please not Register License yet!!!");
        }
    }
}
