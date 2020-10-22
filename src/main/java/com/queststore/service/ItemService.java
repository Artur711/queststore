package com.queststore.service;

import com.queststore.model.Item;
import com.queststore.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void buyItem(Long itemId, Long codecoolerId){
        repository.insertItemIntoTable(itemId, codecoolerId);
    }

    public List<Item> getCodecoolerItems(Long codecoolerId){
        List<Long> itemsIds = repository.getUserItems(codecoolerId);
        List<Item> itemsList = new ArrayList<>();
        for (Long itemId: itemsIds){
            itemsList.add(repository.findById(itemId).get());
        }
        return  itemsList;
    }

    public List<Item> getListOfItems(List<Long> itemsId) {
        List<Item> resultList = new ArrayList<>();
        for (Long itemId: itemsId) {
            resultList.add(repository.findById(itemId).get());
        }

        return resultList;
    }

    public List<Item> getUniqueItems(Long codecoolerId) {

        List<Long> allItemsId = new ArrayList<>(repository.getAllItemsId(codecoolerId));
        allItemsId.removeAll(new ArrayList<>(repository.getUserItems(codecoolerId)));

        return getListOfItems(allItemsId);
    }
}
