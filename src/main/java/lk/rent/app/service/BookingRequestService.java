package lk.rent.app.service;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.BookingRequestDTO;


import java.util.List;

public interface BookingRequestService {
    void addRequest(BookingRequestDTO bookingRequestDTO);
    void updateRequest(BookingRequestDTO bookingRequestDTO);
    List<BookingRequestDTO> getRequest();
    void deleteRequest(String id);
    BookingRequestDTO findRequest(String id);
}
