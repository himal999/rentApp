package lk.rent.app.service;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.BookingDetailsDTO;


import java.util.List;

public interface BookingDetailsService {
    void addDetails(BookingDetailsDTO bookingDetailsDTO);
    void updateDetails(BookingDetailsDTO bookingDetailsDTO);
    List<BookingDetailsDTO> getDetails();
    void deleteDetails(String id);
    BookingDetailsDTO findDetails(String id);
}
