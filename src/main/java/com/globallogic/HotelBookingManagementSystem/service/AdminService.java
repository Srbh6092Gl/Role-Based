package com.globallogic.HotelBookingManagementSystem.service;

import com.globallogic.HotelBookingManagementSystem.entity.Admin;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminService {

    Admin signIn(Admin admin);

    Admin signOut(Admin admin);

    Admin getAdminByUsername(String admin_name) throws UsernameNotFoundException;

    Admin addAdmin(Admin admin);

    boolean existsByAdmin_name(String username);
}
