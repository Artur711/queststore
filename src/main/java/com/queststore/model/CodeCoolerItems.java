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
@Table(name = "codeCooler_items")
public class CodeCoolerItems {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeCooler_item_id")
    private @Id @Setter(AccessLevel.PROTECTED) long codeCoolerItemID;

    @Column(name = "item_id")
    private long itemID;

    @Column(name = "codeCooler_id")
    private long codeCoolerID;

    private String name;
    private String used;

    public CodeCoolerItems(long codeCoolerItemID, long itemID, long codeCoolerID, String name, String used) {
        this.codeCoolerItemID = codeCoolerItemID;
        this.itemID = itemID;
        this.codeCoolerID = codeCoolerID;
        this.name = name;
        this.used = used;
    }
}
