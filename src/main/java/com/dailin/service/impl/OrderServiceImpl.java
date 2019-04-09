package com.dailin.service.impl;

import com.dailin.dto.OrderDTO;
import com.dailin.service.IOrderService;

public class OrderServiceImpl implements IOrderService {
    @Override
    public String handle(OrderDTO dto) {
        String type = dto.getType();
        if ("1".equals(type)) {
            return "处理普通订单";
        } else if ("2".equals(type)) {
            return "处理团购订单";
        } else if ("3".equals(type)) {
            return "处理促销订单";
        }
        return null;
    }
}
