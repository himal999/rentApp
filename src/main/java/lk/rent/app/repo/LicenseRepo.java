package lk.rent.app.repo;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepo extends JpaRepository<License,String> {
}
