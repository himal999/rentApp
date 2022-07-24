package lk.rent.app.dto;/*
author :Himal
version : 0.0.1
*/



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SearchDTO {
    private String pickupBranch;
    private String pickupDate;
    private String returnDate;
    private String type;
    private String vehicleType;
}
