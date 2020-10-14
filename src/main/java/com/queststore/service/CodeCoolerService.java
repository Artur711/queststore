package com.queststore.service;

import com.queststore.model.CodeCooler;
import com.queststore.model.CodeCoolerItems;
import com.queststore.repository.CodeCoolerRepository;
import com.queststore.repository.QuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeCoolerService {

    private CodeCoolerRepository repository;
    private CodeCoolerItemsService codeCoolerItemsService;
    private ItemService itemService;
    private QuestRepository questRepository;

    public CodeCoolerService(QuestRepository questRepository, CodeCoolerRepository repository, CodeCoolerItemsService codeCoolerItemsService, ItemService itemService) {
        this.questRepository = questRepository;
        this.repository = repository;
        this.codeCoolerItemsService = codeCoolerItemsService;
        this.itemService = itemService;

    }

    public void save(CodeCooler codeCooler) {
        codeCooler.setUserType(1);
        repository.save(codeCooler);
    }

    public void updateCodeCoolerItems(long userId, int coins, long itemId) {
        CodeCooler codeCooler = getCodeCoolerById(userId);
        codeCooler.setCodeCoolCoins(coins);
        repository.save(codeCooler);

        CodeCoolerItems coolerItems = new CodeCoolerItems();
        coolerItems.setCodeCoolerID(userId);
        coolerItems.setItemID(itemId);
        coolerItems.setName(itemService.getById(itemId).getName());
        codeCoolerItemsService.create(coolerItems);
    }

    public void updateCoinsBalance(int coins, Long userId){
        repository.updateCoinsBalance(coins, userId);
    }

    public List<CodeCooler> getAll() {
        return repository.findAll();
    }

    public CodeCooler getCodeCoolerById(long id) {
        List<CodeCooler> codeCoolerList = repository.findAll();
        return codeCoolerList.stream().filter(user -> user.getUserId() == id).findAny().orElse(null);
    }

    public void delete(Long id) {
        repository.delete(getCodeCoolerById(id));
    }

}
