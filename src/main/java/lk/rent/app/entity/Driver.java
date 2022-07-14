package lk.rent.app.entity;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Driver {
    @Id
    private String licenseNo;
    @Embedded
    private Name name;
    private String address;
    private String dob;
    private String nic;
    private String email;
    private String tel;
}
