package com.globallogic.HotelBookingManagementSystem.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @NotBlank
    @OneToOne(cascade = CascadeType.ALL)
    private Transaction transaction;

}
