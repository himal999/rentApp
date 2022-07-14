package lk.rent.app.controller;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.BookingRequestDTO;
import lk.rent.app.service.BookingRequestService;
import lk.rent.app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booking")
@CrossOrigin
public class BookingRequestController {

    @Autowired
    BookingRequestService bookingRequestService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil booking(@RequestBody BookingRequestDTO bookingRequestDTO){
        System.out.println(bookingRequestDTO.toString());
        bookingRequestService.addRequest(bookingRequestDTO);
        return new ResponseUtil(200, "Ok", null);
    }
}
