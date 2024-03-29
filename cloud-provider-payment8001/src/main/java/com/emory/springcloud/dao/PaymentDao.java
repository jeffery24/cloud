package com.emory.springcloud.dao;

import com.emory.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
