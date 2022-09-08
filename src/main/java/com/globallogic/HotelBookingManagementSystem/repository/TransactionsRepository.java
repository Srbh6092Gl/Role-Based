package com.globallogic.HotelBookingManagementSystem.repository;

import com.globallogic.HotelBookingManagementSystem.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction,Integer> {
}
