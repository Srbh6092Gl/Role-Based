package com.globallogic.HotelBookingManagementSystem.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="admin",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "adminName")
})
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @NotBlank
    private String adminName;

    @NotBlank
    private String password;

}
