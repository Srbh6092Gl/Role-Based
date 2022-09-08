package com.globallogic.HotelBookingManagementSystem.service;

import com.globallogic.HotelBookingManagementSystem.entity.BookingDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailsService {

    List<BookingDetails> showAllBookingDetails();

    BookingDetails showBookingDetails(int id);

    BookingDetails addBookingDetails(BookingDetails bookingDetails);

    BookingDetails removeBookingDetails(BookingDetails bookingDetails);

    BookingDetails updateBookingDetails(BookingDetails bookingDetails);
}
