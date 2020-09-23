package com.queststore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Codecoolers {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codecooler_id;

    private int user_id;
    private int loe_id;
    private int codecool_coins;

    public Codecoolers() {
    }


    public Codecoolers(long codecooler_id, int user_id, int loe_id, int codecool_coins) {
        this.codecooler_id = codecooler_id;
        this.user_id = user_id;
        this.loe_id = loe_id;
        this.codecool_coins = codecool_coins;
    }

    public Codecoolers(int user_id, int loe_id, int codecool_coins) {
        this.user_id = user_id;
        this.loe_id = loe_id;
        this.codecool_coins = codecool_coins;
    }

    public long getCodecooler_id() {
        return codecooler_id;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLoe_id() {
        return loe_id;
    }

    public void setLoe_id(int loe_id) {
        this.loe_id = loe_id;
    }

    public int getCodecool_coins() {
        return codecool_coins;
    }

    public void setCodecool_coins(int codecool_coins) {
        this.codecool_coins = codecool_coins;
    }
}
