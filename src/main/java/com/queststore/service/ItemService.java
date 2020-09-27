package com.queststore.service;

import com.queststore.dao.ItemDAO;
import com.queststore.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemDAO dao;

    public ItemService(ItemDAO dao) {
        this.dao = dao;
    }

    public void create(Item item) {
        dao.create(item);
    }

    public void update(Item item) {
        dao.update(item);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public List<Item> getAll(){
        return dao.getAll();
    }

    public Item getById(Long id) {
        return dao.getByID(id);
    }
}
