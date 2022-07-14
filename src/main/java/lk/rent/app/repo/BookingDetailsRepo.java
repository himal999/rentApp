package lk.rent.app.repo;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.entity.BookingDetails;
import lk.rent.app.entity.RequestBookingVehicle_PK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailsRepo extends JpaRepository<BookingDetails,RequestBookingVehicle_PK> {

}
