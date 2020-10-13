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
@Table(name = "quests")
public class Quest {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quest_id")
    private @Id @Setter(AccessLevel.PROTECTED) long questId;

    private String name;

    private String description;

    @Column(name = "quest_type_id")
    private int questTypeId;

    private String img;

    @Column(name = "quest_value")
    private int questValue;


    @ManyToMany
            @JoinTable(joinColumns = @JoinColumn(name = "quest_id"),
            inverseJoinColumns = @JoinColumn(name = "codecooler_id"))
    List<CodeCooler> codecoolers;

    public Quest(long questId, String name, String description, int questTypeId, String img, int questValue) {
        this.questId = questId;
        this.name = name;
        this.description = description;
        this.questTypeId = questTypeId;
        this.img = img;
        this.questValue = questValue;
    }
}
