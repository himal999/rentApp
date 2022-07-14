package lk.rent.app.entity;/*
author :Himal
version : 0.0.1
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
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
    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<BookingDetails> bookingDetails;
    private int noOfVehicles;
    private String requestDate;
    private String requestTime;

}
