package com.business.order_service.controller;

import com.business.order_service.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;
}
