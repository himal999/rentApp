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
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class BookingRequest {
    @Id
    private String requestId;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerNIC",referencedColumnName = "nic",nullable = false)
    private Customer customer;
    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "payment_id",referencedColumnName = "id",nullable = false)
    private Payements payements;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "dis_id",referencedColumnName = "discountID",nullable = false)
    private Discount discount;
    @OneToMany(mappedBy = "bookingRequest",cascade = CascadeType.ALL)
    private List<BookingDetails> bookingDetails;
    private int noOfVehicles;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate requestDate;
    @JsonFormat(pattern = "hh:mm:ss a")
    private LocalTime requestTime; //call me

}
