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

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codeCooler_item_id")
    private @Id @Setter(AccessLevel.PROTECTED) long codeCoolerItemID;

    @Column(name = "item_id")
    private int itemID;

    @Column(name = "codeCooler_id")
    private long codeCoolerID;

    private String used;

    public CodeCoolerItems(long codeCoolerItemID, int itemID, long codeCoolerID, String used) {
        this.codeCoolerItemID = codeCoolerItemID;
        this.itemID = itemID;
        this.codeCoolerID = codeCoolerID;
        this.used = used;
    }
}
