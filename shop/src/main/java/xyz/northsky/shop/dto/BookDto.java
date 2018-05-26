package xyz.northsky.shop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class BookDto implements Serializable {

    private Integer bookId;
    private String bookName;
    private BigDecimal singleMoney;
    private Integer quantity;
    private BigDecimal singleTotal;

    public BookDto() {
    }

    public BookDto(Integer bookId, String bookName, BigDecimal singleMoney, Integer quantity, BigDecimal singleTotal) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.singleMoney = singleMoney;
        this.quantity = quantity;
        this.singleTotal = singleTotal;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public BigDecimal getSingleTotal() {
        return singleTotal;
    }

    public void setSingleTotal(BigDecimal singleTotal) {
        this.singleTotal = singleTotal;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", singleMoney=" + singleMoney +
                ", quantity=" + quantity +
                ", singleTotal=" + singleTotal +
                '}';
    }
}
