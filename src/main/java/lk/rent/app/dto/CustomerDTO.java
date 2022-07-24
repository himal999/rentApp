package lk.rent.app.dto;/*
author :Himal
version : 0.0.1
*/

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.rent.app.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String nic;
    private Name name;
    private String address;
    private String tel;
    private String email;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dob;
    private int age;
    private String gender;
}
