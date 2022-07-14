package lk.rent.app.entity;/*
author :Himal
version : 0.0.1
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Payements {
    @Id
    private String id;
    private double downPay;
    private double refundAmount;
    private double amount;
}
