package com.emory.cloud.service.impl;

import com.emory.cloud.dao.OrderDao;
import com.emory.cloud.domain.Order;
import com.emory.cloud.service.AccountService;
import com.emory.cloud.service.OrderService;
import com.emory.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;


    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(name = "fsp_create_order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("开始场景订单");
        orderDao.create(order);

        log.info("扣减库存");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("扣减余额");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("修改订单状态");
        orderDao.update(order.getUserId(), 0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了");

    }
}


















