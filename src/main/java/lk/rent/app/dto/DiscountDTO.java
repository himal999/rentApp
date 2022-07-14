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
public class DiscountDTO {
    private String discountID;
    private String discount;
    private String description;
}
