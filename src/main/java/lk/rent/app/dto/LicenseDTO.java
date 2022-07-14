package lk.rent.app.dto;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.embeded.LicenseEM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class LicenseDTO {
    private String renewId;
    private LicenseEM licenseem;

}
