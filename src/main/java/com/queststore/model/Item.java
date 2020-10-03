package com.queststore.model;

import javax.persistence.Entity;

@Entity
public class Item {

    private long itemId;
    private String name;
    private String description;
    private int price;
    private String img;
    private int itemTypeId;

    public Item(){}

    public Item(Long itemId, String name, String description, int price, String img, int itemTypeId) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
        this.itemTypeId = itemTypeId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
