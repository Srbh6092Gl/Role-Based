package com.globallogic.HotelBookingManagementSystem.controller;

import com.globallogic.HotelBookingManagementSystem.entity.Admin;
import com.globallogic.HotelBookingManagementSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/signIn")
    public String signIn(@RequestBody Admin admin) {
        return "Accessed SignIn";
    }

    @GetMapping("/signOut")
    public String signOut() {
        return "Accessed SignOut";
    }

    @GetMapping("/username/{username}")
    public Admin getAdminByUsername(@PathVariable("username") String username){
        System.err.println("Accessed");
        return adminService.getAdminByUsername(username);
    }

}
