package com.queststore.service;

import com.queststore.dao.CodeCoolerItemsDAO;
import com.queststore.model.CodeCoolerItems;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeCoolerItemsService {

    private final CodeCoolerItemsDAO dao;

    public CodeCoolerItemsService(CodeCoolerItemsDAO dao) {
        this.dao = dao;
    }

    public List<CodeCoolerItems> getAll() {
        return dao.getAll();
    }

    public List<CodeCoolerItems> getByCodeCoolerID(long id) {
        return dao.getByCodeCoolerID(id);
    }

    public void markUsedItem(Long id) {
        dao.markUsedItem(id);
    }
}
