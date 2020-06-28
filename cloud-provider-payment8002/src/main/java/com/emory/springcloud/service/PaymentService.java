package com.emory.springcloud.service;

import com.emory.springcloud.entity.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
