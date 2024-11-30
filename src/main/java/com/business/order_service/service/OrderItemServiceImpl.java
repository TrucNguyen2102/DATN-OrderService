package com.business.order_service.service;

import com.business.order_service.entity.OrderItem;
import com.business.order_service.repository.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    private OrderItemRepo orderItemRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${menu.service.url}")
    private String menuServiceUrl;

    @Value("${invoice.service.url}")
    private String invoiceServiceUrl;

    public OrderItemServiceImpl(OrderItemRepo orderItemRepo, RestTemplate restTemplate, @Value("${menu.service.url}") String menuServiceUrl, @Value("${invoice.service.url}") String invoiceServiceUrl) {
        this.orderItemRepo = orderItemRepo;
        this.restTemplate = restTemplate;
        this.menuServiceUrl = menuServiceUrl;
        this.invoiceServiceUrl = invoiceServiceUrl;
    }

    @Override
    public List<OrderItem> getAllOrders() {
        return orderItemRepo.findAll();
    }

//    // Lấy OrderItem theo id
//    public OrderItem getOrderItemById(Integer id) {
//        return orderItemRepo.findById(id).orElse(null);
//    }

    public List<OrderItem> getOrdersByInvoiceId(Integer invoiceId) {
        return orderItemRepo.findByInvoiceId(invoiceId);  // Lấy đơn hàng theo invoiceId
    }

//    public void createOrderItem(OrderItemRequest orderItemRequest) {
//        // Kiểm tra menuId trong menu-service
//        String url = menuServiceUrl + "/" + orderItemRequest.getMenuId();
//        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);
//
//        if (response.getBody() == null || !response.getBody()) {
//            throw new RuntimeException("Menu ID không tồn tại: " + orderItemRequest.getMenuId());
//        }
//
//        // Kiểm tra và xử lý trạng thái có thể là null
//        String status = orderItemRequest.getStatus();
//        if (status == null) {
//            status = "Chưa Thanh Toán";  // Gán giá trị mặc định nếu status là null
//        }
//
//        // Mã hóa trạng thái để đảm bảo không có ký tự đặc biệt trong URL
//        String encodedStatus = URLEncoder.encode(status, StandardCharsets.UTF_8);
//
//        // Lấy InvoiceId từ TableService bằng cách gọi API /byTableIdAndStatus/{tableId}/{status}
//        String invoice_url = invoiceServiceUrl + "/byTableIdAndStatus/" + orderItemRequest.getTableId() + "/" + encodedStatus;
//        ResponseEntity<Integer> invoiceResponse = restTemplate.getForEntity(invoice_url, Integer.class);
//
//        if (invoiceResponse.getBody() == null) {
//            throw new RuntimeException("Không tìm thấy InvoiceId cho TableId: " + orderItemRequest.getTableId());
//        }
//
//        Integer invoiceId = invoiceResponse.getBody();
//
//        //lưu vào OrderItem
//        OrderItem orderItem = new OrderItem(
//                orderItemRequest.getQuantity(),
//                orderItemRequest.getPrice(),
//                orderItemRequest.getMenuId(),
//                invoiceId
//        );
//        orderItemRepo.save(orderItem);
//    }
}
