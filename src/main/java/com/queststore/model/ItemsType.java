package com.queststore.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "items_type")
public class ItemsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_type_id")
    @Setter(AccessLevel.PROTECTED)
    private long questTypeId;

    private String name;

    public ItemsType(long questTypeId, String name) {
        this.questTypeId = questTypeId;
        this.name = name;
    }
}
