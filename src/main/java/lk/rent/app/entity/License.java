package lk.rent.app.entity;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.embeded.LicenseEM;
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
public class License {
    @Id
    private String renewId;
    @Embedded
    private LicenseEM licenseem;
}
