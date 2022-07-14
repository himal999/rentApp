package lk.rent.app.dto;/*
author :Himal
version : 0.0.1
*/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchDTO {
    private String branchID;
    private String location;
}