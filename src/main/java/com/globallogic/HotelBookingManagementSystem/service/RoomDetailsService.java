package com.globallogic.HotelBookingManagementSystem.service;

import com.globallogic.HotelBookingManagementSystem.entity.RoomDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDetailsService {

    List<RoomDetails> showAllRoomDetails();

    RoomDetails showRoomDetails(int id);

    RoomDetails addRoomDetails(RoomDetails roomDetails);

    RoomDetails removeRoomDetails(RoomDetails roomDetails);

    RoomDetails updateRoomDetails(RoomDetails roomDetails);

}
