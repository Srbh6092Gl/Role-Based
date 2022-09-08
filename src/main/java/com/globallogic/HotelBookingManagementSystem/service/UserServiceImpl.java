package com.globallogic.HotelBookingManagementSystem.service;

import com.globallogic.HotelBookingManagementSystem.entity.User;
import com.globallogic.HotelBookingManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User removeUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUByUserName(username);
        if (!user.isPresent())
            throw new UsernameNotFoundException("Customer not found");
        return user.get();
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByMobile(String mobile) {
        return userRepository.existsByMobile(mobile);
    }
}
