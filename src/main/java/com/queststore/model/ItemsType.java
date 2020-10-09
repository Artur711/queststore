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

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_type_id")
    private @Id @Setter(AccessLevel.PROTECTED) long questTypeId;

    private String name;

    public ItemsType(long questTypeId, String name) {
        this.questTypeId = questTypeId;
        this.name = name;
    }
}
