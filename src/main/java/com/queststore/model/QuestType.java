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
@Table(name = "quest_type")
public class QuestType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quest_type_id")
    @Setter(AccessLevel.PROTECTED)
    private long questTypeId;

    private String name;

    public QuestType(long questTypeId, String name) {
        this.questTypeId = questTypeId;
        this.name = name;
    }
}
