package com.dailin.controller;

import com.dailin.dto.OrderDTO;
import com.dailin.service.impl.OrderServiceV2Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("te")
public class TestController {

    @Autowired
    private OrderServiceV2Impl orderService;

    @PostMapping("test")
    public String dealTest(@RequestBody  OrderDTO dto) {
       return orderService.handle(dto);
    }
    @RequestMapping("ok")
    public String todo() {
        return "1";
    }
}
