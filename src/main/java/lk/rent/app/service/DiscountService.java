package lk.rent.app.service;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.DiscountDTO;
import lk.rent.app.dto.VehicleDTO;


import java.util.List;

public interface DiscountService {
    void addDiscount(DiscountDTO discountDTO);
    void updateDiscount(DiscountDTO discountDTO);
    List<DiscountDTO> getDiscount();
    void deleteDiscount(String id);
    DiscountDTO findDiscount(String id);
}
