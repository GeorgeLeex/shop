package xyz.northsky.shop.entity;

import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class OrderDetail {
    private Integer id;

    private Integer orderId;

    private Integer bookId;

    private BigDecimal singleMoney;

    private Integer quantity;

    private BigDecimal total;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public BigDecimal getSingleMoney() {
        return singleMoney;
    }

    public void setSingleMoney(BigDecimal singleMoney) {
        this.singleMoney = singleMoney;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}