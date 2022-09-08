package com.globallogic.HotelBookingManagementSystem.service;

import com.globallogic.HotelBookingManagementSystem.entity.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionService {

    Transaction addTransaction(Transaction transaction);
}
