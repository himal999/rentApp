package lk.rent.app.service.impl;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.BranchDTO;
import lk.rent.app.entity.Branch;
import lk.rent.app.repo.BranchRepo;
import lk.rent.app.service.BranchService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

    @Autowired
    BranchRepo branchRepo;
    @Autowired
    ModelMapper mapper;

    public void addBranch(BranchDTO branchDTO) {
            if(!branchRepo.existsById(branchDTO.getBranchID())){
                branchRepo.save(mapper.map(branchDTO,Branch.class));
            }else{
                throw new RuntimeException("Branch "+branchDTO.getBranchID()+" Already Exists !!!");
            }
    }

    public void updateBranch(BranchDTO branchDTO) {
            if(branchRepo.existsById(branchDTO.getBranchID())){
                branchRepo.save(mapper.map(branchDTO,Branch.class));
            }else{
                throw new RuntimeException("Please Register first !!!");
            }
    }

    public List<BranchDTO> getBranch() {
        return mapper.map( branchRepo.findAll(),new TypeToken<List<BranchDTO>>(){}.getType());
    }

    public void deleteBranch(String id) {
        if(branchRepo.existsById(id)){
            branchRepo.deleteById(id);
        }else{
            throw new RuntimeException("Can't remove Branch,Please not Register Branch yet!!!");
        }

    }

    public BranchDTO findBranch(String id) {
        if(branchRepo.existsById(id)){
            return mapper.map(branchRepo.findById(id),BranchDTO.class);
        }else{
            throw new RuntimeException("Can't find Branch,Please not Register Branch yet!!!");
        }
    }
}
