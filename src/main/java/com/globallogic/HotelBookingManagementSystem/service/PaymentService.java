package com.globallogic.HotelBookingManagementSystem.service;

import com.globallogic.HotelBookingManagementSystem.entity.Payment;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentService {

    Payment addPayment(Payment payment);

}
