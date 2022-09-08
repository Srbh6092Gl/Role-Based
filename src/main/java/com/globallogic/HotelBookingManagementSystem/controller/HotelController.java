package com.globallogic.HotelBookingManagementSystem.controller;
import com.globallogic.HotelBookingManagementSystem.entity.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    @GetMapping
    public List<Hotel> showAllHotels(){
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Hotel showHotel(@PathVariable("id") int id){
        return null;
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return null;
    }

    @DeleteMapping
    public Hotel removeHotel(@RequestBody Hotel hotel) {
        return null;
    }

    @PutMapping
    public Hotel updateHotel(@RequestBody Hotel hotel) {
        return null;
    }
}
