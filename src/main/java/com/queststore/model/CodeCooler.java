package com.queststore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "codeCoolers")
public class CodeCooler extends User {

    private long exp;
    @Column(name = "codeCooler_coins")
    private int codeCoolCoins;

    private int earned;

    @ManyToMany(mappedBy = "codecoolers")
    List<Quest> quests;

    @ManyToMany(mappedBy = "codecoolers")
    List<Item> items;

    public CodeCooler(long userId, String firstName, String lastName, String email, String password, String photoUrl,
                      int phoneNumber, int userType, long exp, int codeCoolCoins, int earned) {
        super(userId, firstName, lastName, email, password, photoUrl, phoneNumber, userType);
        this.exp = exp;
        this.codeCoolCoins = codeCoolCoins;
        this.earned = earned;
    }
}
