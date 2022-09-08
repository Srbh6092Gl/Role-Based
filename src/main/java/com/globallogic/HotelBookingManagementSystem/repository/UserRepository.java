package com.globallogic.HotelBookingManagementSystem.repository;

import com.globallogic.HotelBookingManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
//    @Query(value = "SELECT * FROM user WHERE user_name=username", nativeQuery = true)
    Optional<User> findUByUserName(String username);

    boolean existsByUserName(String username);

    boolean existsByEmail(String email);

    boolean existsByMobile(String mobile);
}
