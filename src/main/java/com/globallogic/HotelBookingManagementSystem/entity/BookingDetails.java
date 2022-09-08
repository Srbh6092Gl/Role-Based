package com.globallogic.HotelBookingManagementSystem.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="booking_details")
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Hotel hotel;

    @NotNull
    @OneToMany(cascade = CascadeType.MERGE)
    private List<RoomDetails> roomDetails;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @NotNull
    private Date bookedFrom;

    @NotNull
    private Date bookedTo;

    @NotNull
    private int noOfAdults;

    @NotNull
    private int noOfChildren;

    @NotNull
    private double amount;

}
