package com.emory.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.emory.springcloud.entity.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----2");
    }
}
