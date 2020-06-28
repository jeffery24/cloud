package com.emory.springcloud.dao;

import com.emory.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
