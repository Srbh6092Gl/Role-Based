package com.globallogic.HotelBookingManagementSystem.repository;

import com.globallogic.HotelBookingManagementSystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Optional<Admin> findAdminByAdminName(String admin_name);

    boolean existsByAdminName(String username);
}
