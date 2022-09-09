package com.globallogic.HotelBookingManagementSystem.controller;

import com.globallogic.HotelBookingManagementSystem.entity.Admin;
import com.globallogic.HotelBookingManagementSystem.entity.Role;
import com.globallogic.HotelBookingManagementSystem.entity.User;
import com.globallogic.HotelBookingManagementSystem.entity.request.SignInRequest;
import com.globallogic.HotelBookingManagementSystem.entity.request.SignUpRequest;
import com.globallogic.HotelBookingManagementSystem.entity.response.MessageResponse;
import com.globallogic.HotelBookingManagementSystem.jwt.JwtUtil;
import com.globallogic.HotelBookingManagementSystem.service.AdminService;
import com.globallogic.HotelBookingManagementSystem.service.UserService;
import com.globallogic.HotelBookingManagementSystem.service.jwtService.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        if(userService.existsByUsername(signUpRequest.getUserName())){
            return ResponseEntity
                    .badRequest()
                    .body(MessageResponse.builder().message("Error: Username already exists!").build());
        }

        if(userService.existsByEmail(signUpRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(MessageResponse.builder().message("Error: Email already exists!").build());
        }

        if(userService.existsByMobile(signUpRequest.getMobile())){
            return ResponseEntity
                    .badRequest()
                    .body(MessageResponse.builder().message("Error: Mobile no. already exists!").build());
        }
        //Adding to the user table
        User user = User.builder()
                .userName(signUpRequest.getUserName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(
                        (signUpRequest.getRole().equalsIgnoreCase("ADMIN"))
                                ? Role.ADMIN
                                : Role.CUSTOMER
                )
                .address(signUpRequest.getAddress())
                .mobile(signUpRequest.getMobile())
                .build();
        userService.addUser(user);

        //If the role is admin, adding to the admin table
        if(user.getRole()== Role.ADMIN){
            Admin admin = Admin.builder()
                .adminId(
                        userService
                                .getUserByUsername(user.getUserName())
                                .getUserId()
                )
                .adminName(user.getUserName())
                .password(passwordEncoder.encode(user.getPassword()))
                .build();
            adminService.addAdmin(admin);
        }

        return  ResponseEntity.ok(MessageResponse.builder().message("Registered Successfully").build());
    }

    @PostMapping("/signIn")
    public String signIn(@Valid @RequestBody SignInRequest signInRequest)throws Exception{

        if(!userService.existsByUsername(signInRequest.getUsername()))
            return "No user with that username";

//        final boolean isAdmin= adminService.existsByAdmin_name(signInRequest.getUsername());

        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                signInRequest.getUsername(),
                signInRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String role = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList()).get(0);
        System.err.println("AuthController/signIn: "+ role);
//        return ResponseEntity.ok(JwtResponse.builder()
//                .jwt(jwt)
//                .id(userDetails.getId())
//                .username(userDetails.getUsername())
//                .password(userDetails.getPassword())
//                .role(role)
//        );
        return "Token: "+jwt;
    }
}