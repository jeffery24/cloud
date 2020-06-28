package com.emory.springcloud.controller;

import com.emory.springcloud.entity.CommonResult;
import com.emory.springcloud.entity.Payment;
import com.emory.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult insert(@RequestBody Payment payment) {
        int resultCount = paymentService.create(payment);
        log.info("插入结果:" + resultCount);
        if (resultCount > 0) {
            return new CommonResult(200, "插入数据库成功", resultCount);
        } else {
            return new CommonResult(444, "插入数据库失败"+"dsjoifj", null);

        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("插入结果:" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,"+port, payment);
        } else {
            return new CommonResult(444, "查询成功"+port, null);
        }
    }




}





































