package com.emory.cloud.controller;

import com.emory.cloud.domain.CommonResult;
import com.emory.cloud.domain.Order;
import com.emory.cloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/get")
    public CommonResult get()
    {
//        orderService.create(order);
        return new CommonResult(200,"hi");
    }



    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

}
