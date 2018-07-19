package com.ouriques.file.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String itemId;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
