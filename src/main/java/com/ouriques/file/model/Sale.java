package com.ouriques.file.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    private int id;

    @Column
    private String type;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    @Column
    private List<Item> items;

    @Column
    private String salesManName;

    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getSalesManName() {
        return salesManName;
    }

    public void setSalesManName(String salesManName) {
        this.salesManName = salesManName;
    }
}
