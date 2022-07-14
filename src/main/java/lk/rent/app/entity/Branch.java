package lk.rent.app.entity;/*
author :Himal
version : 0.0.1
*/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;



@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Branch {
    @Id
    private String branchID;
    private String location;
}
