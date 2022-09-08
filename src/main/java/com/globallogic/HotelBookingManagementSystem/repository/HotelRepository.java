package com.globallogic.HotelBookingManagementSystem.repository;

import com.globallogic.HotelBookingManagementSystem.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository  extends JpaRepository<Hotel,Integer> {
}
