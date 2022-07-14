package lk.rent.app.service.impl;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.BookingDetailsDTO;
import lk.rent.app.repo.BookingDetailsRepo;
import lk.rent.app.service.BookingDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingDetailsImpl implements BookingDetailsService {

    @Autowired
    BookingDetailsRepo bookingDetailsRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addDetails(BookingDetailsDTO bookingDetailsDTO) {

    }

    @Override
    public void updateDetails(BookingDetailsDTO bookingDetailsDTO) {

    }

    @Override
    public List<BookingDetailsDTO> getDetails() {
        return null;
    }

    @Override
    public void deleteDetails(String id) {

    }

    @Override
    public BookingDetailsDTO findDetails(String id) {
        return null;
    }
}
