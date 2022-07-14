package lk.rent.app.entity;/*
author :Himal
version : 0.0.1
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
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
    private String pickupDate;
    private String pickupTime;
    private String returnDate;
    private String driverId;
    private String withDriver;
    private String status;
}
