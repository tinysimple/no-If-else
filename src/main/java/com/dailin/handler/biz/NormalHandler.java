package com.dailin.handler.biz;

import com.dailin.abstracts.AbstractHandler;
import com.dailin.annotation.HandlerType;
import com.dailin.dto.OrderDTO;
import org.springframework.stereotype.Component;

@Component
@HandlerType("1")
public class NormalHandler extends AbstractHandler {

    @Override
    public String handle(OrderDTO dto) {
        return "处理普通订单";
    }
}
