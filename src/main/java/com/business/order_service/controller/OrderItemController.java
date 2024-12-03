package com.business.order_service.controller;

import com.business.order_service.dto.OrderItemRequest;
import com.business.order_service.entity.OrderItem;
import com.business.order_service.repository.OrderItemRepo;
import com.business.order_service.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderItemRepo orderItemRepo;

//    @PostMapping("/add")
//    public ResponseEntity<String> createOrderItem(@RequestBody OrderItemRequest request) {
//        try {
//            orderItemService.createOrderItem(request);
//            return ResponseEntity.ok("Đơn hàng đã được lưu thành công.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Có lỗi xảy ra khi lưu đơn hàng: " + e.getMessage());
//        }
//    }

    @GetMapping("/endpoints")
    public List<Map<String, String>> getEndpoints() {
        return List.of(
                Map.of("service", "order-service", "method", "GET", "url", "/api/orders/all"),
                Map.of("service", "order-service", "method", "POST", "url", "/api/orders/add"),
                Map.of("service", "order-service", "method", "GET", "url", "api/orders/byInvoiceId/{id}")

        );
    }

    @PostMapping("/add")
    public ResponseEntity<?> addOrderItem(@RequestBody OrderItemRequest request) {
        try {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(request.getId());
            orderItem.setQuantity(request.getQuantity());
            orderItem.setTotalPriceItem(request.getPrice());
            orderItem.setMenuId(request.getMenuId());
            orderItem.setInvoiceId(request.getInvoiceId());

            orderItemRepo.save(orderItem); // Lưu vào DB
            return ResponseEntity.ok("Thêm món thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi thêm món.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderItem>> getAllOrders() {
        try {
            List<OrderItem> orderItems = orderItemService.getAllOrders();
            if (orderItems.isEmpty()) {
                return ResponseEntity.noContent().build(); // Nếu danh sách rỗng, trả về mã 204 (No Content)
            }
            return ResponseEntity.ok(orderItems); // Trả về danh sách giá kèm mã 200 (OK)
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Trả về lỗi 500 (Internal Server Error)
        }

    }



    @GetMapping("/byInvoiceId/{invoiceId}")
    public ResponseEntity<List<OrderItem>> getOrdersByInvoiceId(@PathVariable Integer invoiceId) {
        try {
            List<OrderItem> orders = orderItemService.getOrdersByInvoiceId(invoiceId);
            return ResponseEntity.ok(orders);
        }catch (Exception e) {
            e.printStackTrace();
           return ResponseEntity.badRequest().build();
        }

    }

}
