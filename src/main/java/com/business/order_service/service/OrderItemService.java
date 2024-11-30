package com.business.order_service.service;

import com.business.order_service.dto.OrderItemRequest;
import com.business.order_service.entity.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {
//    void createOrderItem(OrderItemRequest orderItemRequest);
    List<OrderItem> getOrdersByInvoiceId(Integer invoiceId);
//    OrderItem getOrderItemById(Integer id);

    List<OrderItem> getAllOrders();
}
