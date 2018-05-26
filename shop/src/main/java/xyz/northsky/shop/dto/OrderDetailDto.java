package xyz.northsky.shop.dto;

import java.math.BigDecimal;

public class OrderDetailDto {

    private Integer id;
    private String name;
    private String author;
    private String image;
    private BigDecimal single_money;
    private Integer quantity;
    private BigDecimal totalMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getSingle_money() {
        return single_money;
    }

    public void setSingle_money(BigDecimal single_money) {
        this.single_money = single_money;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", single_money=" + single_money +
                ", quantity=" + quantity +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
