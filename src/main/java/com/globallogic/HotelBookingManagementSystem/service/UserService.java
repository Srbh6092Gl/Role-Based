package com.globallogic.HotelBookingManagementSystem.service;

import com.globallogic.HotelBookingManagementSystem.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    List<User> getAllUsers();

    User getUser(int id);

    User addUser(User user);

    User removeUser(User user);

    User updateUser(User user);

    User getUserByUsername(String username) throws UsernameNotFoundException;

    boolean existsByUsername(String user_name);

    boolean existsByEmail(String email);

    boolean existsByMobile(String email);
}
