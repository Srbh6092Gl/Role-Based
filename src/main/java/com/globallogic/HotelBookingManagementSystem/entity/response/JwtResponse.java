package com.globallogic.HotelBookingManagementSystem.entity.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtResponse {

    private String jwt;

    private int id;

    private String username;

    private String password;

    private String role;

}
