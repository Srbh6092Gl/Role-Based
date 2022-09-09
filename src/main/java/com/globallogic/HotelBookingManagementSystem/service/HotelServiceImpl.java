package com.globallogic.HotelBookingManagementSystem.service;

import com.globallogic.HotelBookingManagementSystem.entity.Hotel;
import com.globallogic.HotelBookingManagementSystem.exception.NotFoundException;
import com.globallogic.HotelBookingManagementSystem.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

    //Creating instance of hotel repository
    @Autowired
    HotelRepository hotelRepository;

    //Getting all hotels
    @Override
    public List<Hotel> showAllHotels() {
        return hotelRepository.findAll();
    }

    //Getting hotel by id
    @Override
    public Hotel showHotel(int id) throws NotFoundException {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if(!hotel.isPresent())
            throw new NotFoundException("No hotel found by id: "+id);
        return hotel.get();
    }

    //Adding a hotel to the repository
    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    //Removing a hotel
    @Override
    public Hotel removeHotel(Hotel hotel) {
        hotelRepository.delete(hotel);
        return hotel;
    }

    //Updating a hotel
    @Override
    public Hotel updateHotel(Hotel changes) {

        //Fetching hotel with the id of the request body's id
        Hotel hotel = hotelRepository.findById(changes.getHotelId()).get();

        //If fetched by id, update the changes in the fetched hotel
        if(hotel != null) {

            //If the changes are not null or empty, then update else don't update
            if(changes.getCity() !=null || !changes.getCity().equals(""))
                hotel.setCity(changes.getCity());
            if(changes.getHotelName() !=null || !changes.getHotelName().equals(""))
                hotel.setHotelName(changes.getHotelName());
            if(changes.getAddress() !=null || !changes.getAddress().equals(""))
                hotel.setAddress(changes.getAddress());
            if(changes.getAvgRatePerDay() != 0.0)
                hotel.setAvgRatePerDay(changes.getAvgRatePerDay());
            if(changes.getEmail()!=null || !changes.getEmail().equals(""))
                hotel.setEmail(changes.getEmail());
            if(changes.getPhone1()!=null || !changes.getPhone1().equals(""))
                hotel.setPhone1(changes.getPhone1());
            if(changes.getPhone2()!=null || changes.getPhone2().equals(""))
                hotel.setPhone2(changes.getPhone2());

            //It will update the following even if the changes are null
            hotel.setDescription(changes.getDescription());
            hotel.setWebsite(changes.getWebsite());

        }

        //Save hotel in the repository
        return hotelRepository.save(hotel);
    }
}
