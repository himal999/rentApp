package lk.rent.app.controller;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.BranchDTO;
import lk.rent.app.service.BranchService;
import lk.rent.app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("branch")
@CrossOrigin
public class BranchController {
    @Autowired
    BranchService branchService;

    @PostMapping(path = "/newBranch", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil newBranch(@RequestBody BranchDTO branchDTO) {
        branchService.addBranch(branchDTO);
        return new ResponseUtil(200, "success", null);
    }

    @GetMapping(path = "/allBranch", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllBranch() {
        return new ResponseUtil(200, "success", branchService.getBranch());
    }

    @PutMapping(path = "/updateDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateBranch(@RequestBody BranchDTO branchDTO) {
        branchService.updateBranch(branchDTO);
        return new ResponseUtil(200, "success", branchService.findBranch(branchDTO.getBranchID()));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteBranch(@PathVariable("id") String id) {
        branchService.deleteBranch(id);
        return new ResponseUtil(200, "success", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findBranch(@PathVariable("id") String id) {
        return new ResponseUtil(200, "success", branchService.findBranch(id));
    }
}
