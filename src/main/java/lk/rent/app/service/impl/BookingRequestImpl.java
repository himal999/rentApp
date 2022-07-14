package lk.rent.app.service.impl;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.BookingRequestDTO;
import lk.rent.app.entity.BookingRequest;
import lk.rent.app.repo.BookingRequestRepo;
import lk.rent.app.service.BookingRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookingRequestImpl implements BookingRequestService {

    @Autowired
    BookingRequestRepo bookingRequestRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addRequest(BookingRequestDTO bookingRequestDTO) {
        if(!bookingRequestRepo.existsById(bookingRequestDTO.getRequestId())){
            bookingRequestRepo.save(mapper.map(bookingRequestDTO, BookingRequest.class));
        }else{

        }
    }

    @Override
    public void updateRequest(BookingRequestDTO bookingRequestDTO) {

    }

    @Override
    public List<BookingRequestDTO> getRequest() {
        return null;
    }

    @Override
    public void deleteRequest(String id) {

    }

    @Override
    public BookingRequestDTO findRequest(String id) {
        return null;
    }
}
