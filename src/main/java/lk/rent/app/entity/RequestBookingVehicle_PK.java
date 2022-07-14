package lk.rent.app.entity;/*
author :Himal
version : 0.0.1
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RequestBookingVehicle_PK implements Serializable {
    private String requestId;
    private String vehicleId;
}
