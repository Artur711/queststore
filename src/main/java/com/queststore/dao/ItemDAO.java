package com.queststore.dao;

import com.queststore.model.Item;

import java.util.List;

public interface ItemDAO {

    List<Item> getAll();

    Item getByID(Long id);

    void delete(Long id);

    void create(Item item);

    void update(Item item);

}
