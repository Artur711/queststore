package com.queststore.service;

import com.queststore.model.CodeCooler;
import com.queststore.model.CodeCoolerItems;
import com.queststore.repository.CodeCoolerItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CodeCoolerItemsService {

    private final CodeCoolerItemsRepository repository;

    public CodeCoolerItemsService(CodeCoolerItemsRepository repository) {
        this.repository = repository;
    }

    public List<CodeCoolerItems> getAll() {
        return repository.findAll();
    }

    public void create(CodeCoolerItems items) {
        items.setUsed("NO");
        repository.save(items);
    }

    public List<CodeCoolerItems> getByCodeCoolerID(long id) {
        List<CodeCoolerItems> coolerItems = repository.findAll();
        return coolerItems.stream().filter(item -> item.getCodeCoolerID() == id).collect(Collectors.toList());
    }

    public CodeCoolerItems getItemById(long id) {
        List<CodeCoolerItems> coolerItems = repository.findAll();
        return coolerItems.stream().filter(items -> items.getCodeCoolerItemID() == id).findAny().orElse(null);
    }

    public void markUsedItem(Long id) {
        CodeCoolerItems item = getItemById(id);
        item.setUsed("YES");
        repository.save(item);
    }
}
