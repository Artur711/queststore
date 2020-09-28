package com.queststore.model;

import javax.persistence.Entity;

@Entity
public class Quest {
    private long questId;
    private String name;
    private String description;
    private int questTypeId;
    private String img;
    private int questValue;

    public Quest(){}

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Quest(long questId, String name, String description, int questTypeId, String img, int questValue) {
        this.questId = questId;
        this.name = name;
        this.description = description;
        this.questTypeId = questTypeId;
        this.img = img;
        this.questValue = questValue;
    }

    public long getQuestId() {
        return questId;
    }

    public void setQuestId(long questId) {
        this.questId = questId;
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

    public int getQuestTypeId() {
        return questTypeId;
    }

    public void setQuestTypeId(int questTypeId) {
        this.questTypeId = questTypeId;
    }

    public int getQuestValue() {
        return questValue;
    }

    public void setQuestValue(int questValue) {
        this.questValue = questValue;
    }
}
