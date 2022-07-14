package lk.rent.app.embeded;/*
author :Himal
version : 0.0.1
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Embeddable
public class Name {
    private String fName;
    private String lName;
}
