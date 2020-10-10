package com.queststore.service;

import com.queststore.model.CodeCooler;
import com.queststore.repository.CodeCoolerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeCoolerService {

    private CodeCoolerRepository repository;

    public CodeCoolerService(CodeCoolerRepository repository) {
        this.repository = repository;
    }

    public void create(CodeCooler codeCooler) {
        codeCooler.setUserType(1);
        repository.save(codeCooler);
    }

//    public void updateCodecoolerItems(int userId, int coins, int itemId) {dao.updateCodecoolerItems(userId, coins, itemId);}

//    public void complateQuest(int userId, int coins, int questId){dao.updateCodecoolerQuests(userId, coins, questId);};

//    public void addItem(int userId, int itemId){};

    public List<CodeCooler> getAll() {
        return repository.findAll();
    }

    public CodeCooler getCodeCoolerById(long id){
        List<CodeCooler> codeCoolerList = repository.findAll();
        return codeCoolerList.stream().filter(user -> user.getUserId() == id).findAny().orElse(null);
    }

    public void delete(Long id) {
        repository.delete(getCodeCoolerById(id));
    }

}
