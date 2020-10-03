package com.queststore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class CodeCoolerItems {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codeCoolerItemID;

    private int itemID;
    private long codeCoolerID;
    private int used;
    private String name;

    public CodeCoolerItems() {

    }

    public CodeCoolerItems(long codeCoolerItemID, int itemID, long codeCoolerID, int used, String name) {
        this.codeCoolerItemID = codeCoolerItemID;
        this.itemID = itemID;
        this.codeCoolerID = codeCoolerID;
        this.used = used;
        this.name = name;
    }

    public long getCodeCoolerItemID() {
        return codeCoolerItemID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public long getCodeCoolerID() {
        return codeCoolerID;
    }

    public void setCodeCoolerID(long codeCoolerID) {
        this.codeCoolerID = codeCoolerID;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
