package com.globallogic.HotelBookingManagementSystem.service;

import com.globallogic.HotelBookingManagementSystem.entity.Admin;
import com.globallogic.HotelBookingManagementSystem.exception.NotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminService {

    Admin signIn(Admin admin);

    Admin signOut(Admin admin);

    Admin getAdminByUsername(String admin_name) throws UsernameNotFoundException;

    Admin addAdmin(Admin admin);

    List<Admin> getAllAdmins();

    Admin getAdmin(int id) throws NotFoundException;

    void removeAdminById(int id) throws NotFoundException;

    Admin updateAdmin(int id);

    boolean existsByAdmin_name(String username);
}
