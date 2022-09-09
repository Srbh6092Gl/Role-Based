package com.globallogic.HotelBookingManagementSystem.controller;
import com.globallogic.HotelBookingManagementSystem.entity.Hotel;
import com.globallogic.HotelBookingManagementSystem.exception.NotFoundException;
import com.globallogic.HotelBookingManagementSystem.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping
    public List<Hotel> showAllHotels(){
        return hotelService.showAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel showHotel(@PathVariable("id") int id) throws NotFoundException {
        return hotelService.showHotel(id);
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @DeleteMapping
    public Hotel removeHotel(@RequestBody Hotel hotel) {
        return hotelService.removeHotel(hotel);
    }

    @PutMapping
    public Hotel updateHotel(@RequestBody Hotel hotel) {
        return hotelService.updateHotel(hotel);
    }
}
