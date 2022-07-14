package lk.rent.app.repo;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
}
