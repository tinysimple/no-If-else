package com.dailin.service.impl;

import com.dailin.abstracts.AbstractHandler;
import com.dailin.dto.OrderDTO;
import com.dailin.handler.HandlerContext;
import com.dailin.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV2Impl implements IOrderService {

    @Autowired
    private HandlerContext handlerContext;


    @Override
    public String handle(OrderDTO dto) {
        AbstractHandler handler = handlerContext.getInstance(dto.getType());
        return handler.handle(dto);
//        return null;
    }
}
