package com.globallogic.HotelBookingManagementSystem.entity;

import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="room_details",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "roomNo")
        })
public class RoomDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    @NotNull
    private String roomNo;

    @NotNull
    private String roomType;

    @NotNull
    private Boolean isavailable;

    @NotNull
    @URL
    private String photoURL;

}
