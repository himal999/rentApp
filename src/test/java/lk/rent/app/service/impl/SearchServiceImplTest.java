package lk.rent.app.service.impl;

import lk.rent.app.config.WebAppConfig;
import lk.rent.app.dto.SearchDTO;
import lk.rent.app.entity.BookingDetails;
import lk.rent.app.entity.Branch;
import lk.rent.app.entity.Vehicle;
import lk.rent.app.repo.BookingDetailsRepo;
import lk.rent.app.repo.BranchRepo;
import lk.rent.app.repo.VehicleRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

/*
author :Himal
version : 0.0.1
*/
//@WebAppConfiguration
//@ContextConfiguration(classes = {WebAppConfig.class})
//@ExtendWith(SpringExtension.class)
//@Transactional
class SearchServiceImplTest {

//    @Autowired
//    BranchRepo branchRepo;
//
//    @Autowired
//    BookingDetailsRepo bookingDetailsRepo;
//
//    @Autowired
//    VehicleRepo vehicleRepo;

   // @Test
//    void findAvailableVehicle() {
//        DateTimeFormatter f = new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toFormatter();
//
//        SearchDTO searchDTO = new SearchDTO("Colombo", LocalDate.parse("05-08-2022", f), LocalDate.parse("06-08-2022", f), "Luxary", "car");
//
//        List<Vehicle> availableVehicles = new ArrayList<>();
//
//        List<BookingDetails> bkDetails = bookingDetailsRepo.findAll();
//        List<Vehicle> allVehicles = vehicleRepo.findAll();
//        List<String> bookingVehiclesNo = new ArrayList<>();
//
//
//        //FIND THE BRANCH
//
//        Branch branch = branchRepo.findBranchesByLocation(searchDTO.getPickupBranch());
//
//        // FIND BOOKING VEHICLES AND ADD IN ARRAY ONE OF TIME VEHICLE NUMBER
//        L1:for (BookingDetails bk : bkDetails) {
//            Vehicle vehicle = vehicleRepo.findVehiclesByVehicleNo(bk.getVehicleId());
//            if (vehicle.getVehicleType().equalsIgnoreCase(searchDTO.getVehicleType()) && vehicle.getType().equalsIgnoreCase(searchDTO.getType()) && vehicle.getBranch().getBranchID().equalsIgnoreCase(branch.getBranchID())) {
//                if (bookingVehiclesNo.isEmpty()) {
//                    bookingVehiclesNo.add(bk.getVehicleId());
//                } else {
//                    for (String s : bookingVehiclesNo) {
//                        if (s.equalsIgnoreCase(bk.getVehicleId())) {
//                            continue L1;
//                        }
//                    }
//                    bookingVehiclesNo.add(bk.getVehicleId());
//                }
//            }
//        }
//
//        System.out.println("=================================");
//        for (String i : bookingVehiclesNo) {
//            System.out.println(i);
//        }
//        System.out.println("=================================");
//
//        //FIND THE NOT BOOKING VEHICLES
//
//        l1:
//        for (Vehicle v : allVehicles) {
//            if (v.getVehicleType().equalsIgnoreCase(searchDTO.getVehicleType()) && v.getType().equalsIgnoreCase(searchDTO.getType()) && v.getBranch().getLocation().equalsIgnoreCase(searchDTO.getPickupBranch())) {
//                for (String s : bookingVehiclesNo) {
//                    if (s.equalsIgnoreCase(v.getVehicleNo())) {
//                        continue l1;
//                    }
//                }
//                availableVehicles.add(v);
//            }
//
//        }
//        //FIND BOOKING VEHICLES AVAILABLE OR NOT BY SUCCESS
//
//        //FIND BOOKING VEHICLES AVAILABLE OR NOT BY PENDING
//
//        L1:for (String v : bookingVehiclesNo){
//            List<BookingDetails> bookingDetails = bookingDetailsRepo.findByVehicleId(v);
//            for (BookingDetails bk : bookingDetails) {
//                System.out.println(bk.getVehicleId()+" "+bk.getReturnDate() + " "+searchDTO.getPickupDate()+" "+bk.getStatus());
//                System.out.println(bk.getVehicleId()+" "+bk.getPickupDate() + " "+searchDTO.getReturnDate());
//                if ((bk.getReturnDate().isBefore(searchDTO.getPickupDate()) || bk.getPickupDate().isAfter(searchDTO.getReturnDate())) && bk.getStatus().equalsIgnoreCase("pending")) {
//
//                    if (availableVehicles.isEmpty()) {
//                        availableVehicles.add(vehicleRepo.findVehiclesByVehicleNo(v));
//                    } else {
//                        for (Vehicle tt : availableVehicles) {
//                            if (tt.getVehicleNo().equalsIgnoreCase(v)) {
//                                continue L1;
//                            }
//                        }
//                        availableVehicles.add(vehicleRepo.findVehiclesByVehicleNo(v));
//                    }
//                }else {
//
//                }
//            }
//        }
//
//
////        for(BookingDetails bk:bkDetails){
////          L1:  for(Vehicle allTemp : allVehicles){
////                if(bk.getVehicleId().equalsIgnoreCase(allTemp.getVehicleNo())){
////                    break L1;
////                }
////            }
////            if(notBooking.isEmpty()){
////                notBooking.add(bk.getVehicleId());
////            }else{
////
////            }
////
////        }
////
////
////        Branch branchesByLocation = branchRepo.findBranchesByLocation(searchDTO.getPickupBranch());
////        //System.out.println(branchesByLocation.toString());
////
////
////        List<Vehicle> vehicles = vehicleRepo.findVehiclesByBranchAndTypeAndVehicleType(branchesByLocation.getBranchID(), searchDTO.getType(), searchDTO.getVehicleType());
////
////        for (Vehicle temp : vehicles) {
////            System.out.println(temp.getVehicleNo());
////
////            List<BookingDetails> bookingVehicle = bookingDetailsRepo.findByVehicleId(temp.getVehicleNo());
////
////            for(BookingDetails tempBook:bookingVehicle){
////                System.out.println(tempBook.getVehicleId()+" "+tempBook.getStatus());
////                if((tempBook.getReturnDate().isBefore(searchDTO.getPickupDate()) || tempBook.getPickupDate().isAfter(searchDTO.getReturnDate())) && tempBook.getStatus().equalsIgnoreCase("pending")){
////                    System.out.println(tempBook.getReturnDate()+" "+searchDTO.getPickupDate()+" "+tempBook.getRequestId());
////                   // 16 20
////
////                    if(availableVehicles.isEmpty()){
////                        availableVehicles.add(tempBook.getVehicle());
////                    }
//////                    else{
//////                        for(Vehicle tt:availableVehicles){
//////                            if(!tt.getVehicleNo().equalsIgnoreCase(tempBook.getVehicleId())){
//////                                availableVehicles.add(tt);
//////                            }
//////                        }
//////                    }
////                }
////            }
////        }
////
//        for (Vehicle v : availableVehicles) {
//            System.out.println(v.toString());
//        }
//    }

}
