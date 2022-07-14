package lk.rent.app.dto;/*
author :Himal
version : 0.0.1
*/


import lk.rent.app.entity.BookingDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingRequestDTO {
    private String requestId;
    private CustomerDTO customer;
    private PayementsDTO payements;
    private DiscountDTO discount;
    private int noOfVehicles;
    private String requestDate;
    private String requestTime;
    private List<BookingDetailsDTO> bookingDetails;
}
