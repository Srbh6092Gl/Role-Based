package com.globallogic.HotelBookingManagementSystem.entity.request;

import com.globallogic.HotelBookingManagementSystem.entity.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignUpRequest {

    @NotBlank
    private String userName;

    @NotBlank
    @Email(message = "Invalid email!")
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String role;

    @NotBlank
    private String mobile;

    @NotBlank
    private String address;

}
