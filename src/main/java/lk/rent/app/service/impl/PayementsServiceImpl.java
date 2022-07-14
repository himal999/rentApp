package lk.rent.app.service.impl;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.PayementsDTO;
import lk.rent.app.entity.Payements;
import lk.rent.app.repo.PayementsRepo;
import lk.rent.app.service.PayementsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PayementsServiceImpl implements PayementsService {
    @Autowired
    PayementsRepo payementsRepo;
    @Autowired
    ModelMapper mapper;
    @Override
    public void addPayements(PayementsDTO payementsDTO) {
            if(!payementsRepo.existsById(payementsDTO.getId())){
                payementsRepo.save(mapper.map(payementsDTO, Payements.class));
            }else{
                throw new RuntimeException("Payements "+payementsDTO.getId()+" Already Exists !!!");
            }
    }

    @Override
    public void updatePayements(PayementsDTO payementsDTO) {
            if(payementsRepo.existsById(payementsDTO.getId())){
                payementsRepo.save(mapper.map(payementsDTO, Payements.class));
            }else{
                throw new RuntimeException("Please Register first !!!");
            }
    }

    @Override
    public List<PayementsDTO> getPayements() {
        return mapper.map(payementsRepo.findAll(),new TypeToken<List<PayementsDTO>>(){}.getType());
    }

    @Override
    public void deletePayements(String id) {
        if(payementsRepo.existsById(id)){
            payementsRepo.deleteById(id);
        }else{
            throw new RuntimeException("Can't remove Payements,Please not Register Payements yet!!!");
        }
    }

    @Override
    public PayementsDTO findPayements(String id) {
        if(payementsRepo.existsById(id)){
            return mapper.map(payementsRepo.findById(id),PayementsDTO.class);
        }else{
            throw new RuntimeException("Can't find Payements,Please not Register Payements yet!!!");
        }

    }
}
