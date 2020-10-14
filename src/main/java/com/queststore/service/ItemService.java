package com.queststore.service;

import com.queststore.model.Item;
import com.queststore.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public void create(Item item) {
        repository.save(item);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Item> getAll(){
        return repository.findAll();
    }

    public Item getById(Long id) {
        List<Item> itemList = repository.findAll();
        return itemList.stream().filter(item -> item.getItemId() == id).findAny().orElse(null);
    }
}
