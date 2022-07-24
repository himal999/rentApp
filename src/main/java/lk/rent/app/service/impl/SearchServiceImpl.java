package lk.rent.app.service.impl;/*
author :Himal
version : 0.0.1
*/


import lk.rent.app.dto.SearchDTO;
import lk.rent.app.dto.VehicleDTO;
import lk.rent.app.entity.BookingDetails;
import lk.rent.app.entity.Branch;
import lk.rent.app.entity.Vehicle;
import lk.rent.app.repo.BookingDetailsRepo;
import lk.rent.app.repo.BranchRepo;
import lk.rent.app.repo.VehicleRepo;
import lk.rent.app.service.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    @Autowired
    BranchRepo branchRepo;

    @Autowired
    BookingDetailsRepo bookingDetailsRepo;

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<VehicleDTO> findAvailableVehicle(SearchDTO searchDTO) {
        DateTimeFormatter f = new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();
        List<Vehicle> availableVehicles = new ArrayList<>();

        List<BookingDetails> bkDetails = bookingDetailsRepo.findAll();
        List<Vehicle> allVehicles = vehicleRepo.findAll();
        List<String> bookingVehiclesNo = new ArrayList<>();


        //FIND THE BRANCH

        Branch branch = branchRepo.findBranchesByLocation(searchDTO.getPickupBranch());

        // FIND BOOKING VEHICLES AND ADD IN ARRAY ONE OF TIME VEHICLE NUMBER
        L1:for (BookingDetails bk : bkDetails) {
            Vehicle vehicle = vehicleRepo.findVehiclesByVehicleNo(bk.getVehicleId());
            if (vehicle.getVehicleType().equalsIgnoreCase(searchDTO.getVehicleType()) && vehicle.getType().equalsIgnoreCase(searchDTO.getType()) && vehicle.getBranch().getBranchID().equalsIgnoreCase(branch.getBranchID())) {
                if (bookingVehiclesNo.isEmpty()) {
                    bookingVehiclesNo.add(bk.getVehicleId());
                } else {
                    for (String s : bookingVehiclesNo) {
                        if (s.equalsIgnoreCase(bk.getVehicleId())) {
                            continue L1;
                        }
                    }
                    bookingVehiclesNo.add(bk.getVehicleId());
                }
            }
        }



        //FIND THE NOT BOOKING VEHICLES

        l1:
        for (Vehicle v : allVehicles) {
            if (v.getVehicleType().equalsIgnoreCase(searchDTO.getVehicleType()) && v.getType().equalsIgnoreCase(searchDTO.getType()) && v.getBranch().getLocation().equalsIgnoreCase(searchDTO.getPickupBranch())) {
                for (String s : bookingVehiclesNo) {
                    if (s.equalsIgnoreCase(v.getVehicleNo())) {
                        continue l1;
                    }
                }
                availableVehicles.add(v);
            }

        }


        //FIND BOOKING VEHICLES AVAILABLE OR NOT BY PENDING

        L1:for (String v : bookingVehiclesNo){
            List<BookingDetails> bookingDetails = bookingDetailsRepo.findByVehicleId(v);
            for (BookingDetails bk : bookingDetails) {
                LocalDate pickupDate =LocalDate.parse(searchDTO.getPickupDate(),f);
                LocalDate returnDate =LocalDate.parse(searchDTO.getReturnDate(),f);
                if ((bk.getReturnDate().isBefore(pickupDate) || bk.getPickupDate().isAfter(returnDate)) && bk.getStatus().equalsIgnoreCase("pending")) {

                    if (availableVehicles.isEmpty()) {
                        availableVehicles.add(vehicleRepo.findVehiclesByVehicleNo(v));
                    } else {
                        for (Vehicle tt : availableVehicles) {
                            if (tt.getVehicleNo().equalsIgnoreCase(v)) {
                                continue L1;
                            }
                        }
                        availableVehicles.add(vehicleRepo.findVehiclesByVehicleNo(v));
                    }
                }
            }
        }
       return mapper.map(availableVehicles,new TypeToken<List<VehicleDTO>>(){}.getType());
    }
}
