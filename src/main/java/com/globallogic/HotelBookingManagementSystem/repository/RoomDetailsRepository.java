package com.globallogic.HotelBookingManagementSystem.repository;

import com.globallogic.HotelBookingManagementSystem.entity.RoomDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDetailsRepository extends JpaRepository<RoomDetails,Integer> {
}
