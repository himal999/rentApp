package lk.rent.app.dto;/*
author :Himal
version : 0.0.1
*/



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingRequestDTO {
    private String requestId;
    private CustomerDTO customer;
    private PayementsDTO payements; //sir 1wni sout ek dto eke eke okkma data enwa
    private DiscountDTO discount;
    private int noOfVehicles;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate requestDate;
    @JsonFormat(pattern = "hh:mm:ss a")
    private LocalTime requestTime;
    private List<BookingDetailsDTO> bookingDetails;
}
