package com.queststore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Experience {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long loeID;
    private long value;

    public Experience() {}

    public Experience(long value) {
        this.value = value;
    }

    public Experience(long loeID, long value) {
        this.loeID = loeID;
        this.value = value;
    }

    public long getLoeID() {
        return loeID;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
