package com.business.order_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_price_item")
    private Double totalPriceItem;

    @Column(name = "menu_id")
    private Integer menuId; //khóa ngoại của menu từ menu-service

    @Column(name = "invoice_id")
    private Integer invoiceId; //khóa ngoại của invoice từ invoice-service

    public OrderItem() {

    }
    public OrderItem(Integer id, Integer quantity, Double totalPriceItem, Integer menuId, Integer invoiceId) {
        this.id = id;
        this.quantity = quantity;
        this.totalPriceItem = totalPriceItem;
        this.menuId = menuId;
        this.invoiceId = invoiceId;
    }

    public OrderItem(Integer quantity, Double totalPriceItem, Integer menuId, Integer invoiceId) {
        this.quantity = quantity;
        this.totalPriceItem = totalPriceItem;
        this.menuId = menuId;
        this.invoiceId = invoiceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPriceItem() {
        return totalPriceItem;
    }

    public void setTotalPriceItem(Double totalPriceItem) {
        this.totalPriceItem = totalPriceItem;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }
}
