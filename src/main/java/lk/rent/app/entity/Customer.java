package lk.rent.app.entity;/*
author :Himal
version : 0.0.1
*/

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.rent.app.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dob;
    private String gender;
}
