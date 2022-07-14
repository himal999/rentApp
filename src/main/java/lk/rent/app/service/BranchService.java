package lk.rent.app.service;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.BranchDTO;


import java.util.List;

public interface BranchService {
    void addBranch(BranchDTO branchDTO);
    void updateBranch(BranchDTO branchDTO);
    List<BranchDTO> getBranch();
    void deleteBranch(String id);
    BranchDTO findBranch(String id);
}
