package lk.rent.app.entity;/*
author :Himal
version : 0.0.1
*/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Vehicle {
    @Id
    private String vehicleNo;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "branch_id")
    private Branch branch;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "license_id",referencedColumnName = "renewId",unique = true)
    private License license;
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
    private String status;

}
