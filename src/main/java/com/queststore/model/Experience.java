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
@Table(name = "experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loe_id")
    @Setter(AccessLevel.PROTECTED)
    private long loeID;

    private long value;

    public Experience(long loeID, long value) {
        this.loeID = loeID;
        this.value = value;
    }
}
