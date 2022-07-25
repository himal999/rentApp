package lk.rent.app.dto;/*
author :Himal
version : 0.0.1
*/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VehicleDTO {
    private String vehicleNo;
    private BranchDTO branch;
    private LicenseDTO license;
    private String brand;
    private String model;
    private String engineNo;
    private String chaNo;
    private String engCapacity;
    private String manufactureYear;
    private String regYear;
    private String color;
    private String fuelType;
    private String transmissionType;
    private String acType;
    private int door;
    private String type;
    private String vehicleType;
    private String currentKm;
    private String initKm;
    private int passenger;
    private String speed;
    private String status;
}
