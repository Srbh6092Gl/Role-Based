package com.globallogic.HotelBookingManagementSystem.service;

import com.globallogic.HotelBookingManagementSystem.entity.Admin;
import com.globallogic.HotelBookingManagementSystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin signIn(Admin admin) {
        return null;
    }

    @Override
    public Admin signOut(Admin admin) {
        return null;
    }

    @Override
    public Admin getAdminByUsername(String admin_name) throws UsernameNotFoundException{
        Optional<Admin> admin = adminRepository.findAdminByAdminName(admin_name);
        if (!admin.isPresent())
            throw new UsernameNotFoundException("Admin not found");
        return admin.get();
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public boolean existsByAdmin_name(String username) {
        return adminRepository.existsByAdminName(username);
    }
}
