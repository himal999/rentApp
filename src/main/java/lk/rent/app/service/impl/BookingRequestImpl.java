package lk.rent.app.service.impl;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.BookingRequestDTO;
import lk.rent.app.entity.BookingDetails;
import lk.rent.app.entity.BookingRequest;
import lk.rent.app.entity.Vehicle;
import lk.rent.app.repo.BookingDetailsRepo;
import lk.rent.app.repo.BookingRequestRepo;
import lk.rent.app.repo.VehicleRepo;
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
    private BookingRequestRepo bookingRequestRepo;

    @Autowired
    private BookingDetailsRepo bookingDetailsRepo;

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addRequest(BookingRequestDTO bookingRequestDTO) {
        BookingRequest booking = mapper.map(bookingRequestDTO, BookingRequest.class);
        if(!bookingRequestRepo.existsById(bookingRequestDTO.getRequestId())){
            bookingRequestRepo.save(booking);
            if(bookingRequestDTO.getBookingDetails().size()<1) throw new RuntimeException("No Vehicle added for the Booking..!");

            for (BookingDetails temp:booking.getBookingDetails()) {
                Vehicle vehicle = vehicleRepo.findById(temp.getVehicleId()).get();
                vehicle.setStatus("Not Available");
                vehicleRepo.save(vehicle);
            }
        }else{
            throw new RuntimeException("Vehicle Booking Failed...");
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
