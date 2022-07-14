package lk.rent.app.dto;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.entity.BookingRequest;
import lk.rent.app.entity.Branch;
import lk.rent.app.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingDetailsDTO {

    private String requestId;
    private String vehicleId;
    private BranchDTO branch;
    private String pickupDate;
    private String pickupTime;
    private String returnDate;
    private String driverId;
    private String withDriver;
    private String status;
}
