package com.business.order_service.repository;

import com.business.order_service.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
//    Optional<OrderItem> findById(Integer id);
//    List<OrderItem> findByOrderId(Integer orderId);
    List<OrderItem> findByInvoiceId(Integer invoiceId);
}
