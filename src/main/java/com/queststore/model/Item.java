package com.queststore.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long itemId;

    private String name;

    private String description;

    private int price;

    private String img;

    @Column(name = "item_type_id")
    private int itemTypeId;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "codecooler_id"))
    List<CodeCooler> codecoolers;

    public Item(Long itemId, String name, String description, int price, String img, int itemTypeId) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
        this.itemTypeId = itemTypeId;
    }

    public Item(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
