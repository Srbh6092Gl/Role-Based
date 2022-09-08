package com.globallogic.HotelBookingManagementSystem.service;

import com.globallogic.HotelBookingManagementSystem.entity.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelService {

    List<Hotel> showAllHotels();

    Hotel showHotel(int id);

    Hotel addHotel(Hotel hotel);

    Hotel removeHotel(Hotel hotel);

    Hotel updateHotel(Hotel hotel);
}
