package lk.rent.app.dto;/*
author :Himal
version : 0.0.1
*/

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.rent.app.entity.BookingRequest;
import lk.rent.app.entity.Branch;
import lk.rent.app.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingDetailsDTO {

    private String requestId;
    private String vehicleId;
    private BranchDTO branch;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate pickupDate;
    @JsonFormat(pattern = "hh:mm:ss a")
    private LocalTime pickupTime;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate returnDate;
    private String driverId;
    private String withDriver;
    private String status;
}
