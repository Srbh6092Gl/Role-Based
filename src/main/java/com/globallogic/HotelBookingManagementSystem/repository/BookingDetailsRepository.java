package com.globallogic.HotelBookingManagementSystem.repository;
import com.globallogic.HotelBookingManagementSystem.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailsRepository  extends JpaRepository<BookingDetails,Integer> {
}
