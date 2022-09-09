package com.globallogic.HotelBookingManagementSystem.entity;

import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="hotel",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "hotelName"),
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "phone1"),
                @UniqueConstraint(columnNames = "website")
        })
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;

    @NotNull
    private String city;

    @NotNull
    private String hotelName;

    @NotNull
    private String address;

    @NotNull
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    List<BookingDetails> bookingDetails;

    @NotNull
    private double avgRatePerDay;

    @NotNull
    @Email(message = "Invalid email")
    private String email;

    @NotNull
    @Size(min = 10, max = 10)
    private String phone1;

    @NotNull
    @Size(min = 10, max = 10)
    private String phone2;

    @NotNull
    @URL
    private String website;

}