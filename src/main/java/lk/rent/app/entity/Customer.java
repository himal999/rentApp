package lk.rent.app.entity;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Customer {
    @Id
    private String nic;
    private Name name;
    private String address;
    private String tel;
    private String email;
    private String dob;
    private String gender;
}
