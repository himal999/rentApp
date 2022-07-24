package lk.rent.app.entity;/*
author :Himal
version : 0.0.1
*/

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@IdClass(RequestBookingVehicle_PK.class)
public class BookingDetails {
    @Id
    private String requestId;
    @Id
    private String vehicleId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "branch_Id",referencedColumnName = "branchID")
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "requestId",referencedColumnName = "requestId",insertable = false,updatable = false)
    private BookingRequest bookingRequest;
    @ManyToOne
    @JoinColumn(name = "vehicleId",referencedColumnName = "vehicleNo",insertable = false,updatable = false)
    private Vehicle vehicle;
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
