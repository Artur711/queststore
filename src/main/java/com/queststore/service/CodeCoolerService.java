package com.queststore.service;

import com.queststore.dao.CodeCoolerDAO;
import com.queststore.model.Codecoolers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeCoolerService {
    private final CodeCoolerDAO dao;


    public CodeCoolerService(CodeCoolerDAO dao) {
        this.dao = dao;
    }

    public void create(Codecoolers codeCooler) {
       dao.create(codeCooler);
    }

    public void update(Codecoolers codeCooler) {
        dao.update(codeCooler);
    }

    public List<Codecoolers> getAll() {
        return dao.getAll();
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public Codecoolers getByID(Long id) {
        return dao.getByID(id);
    }

    public Codecoolers getByUserID(long id) {
        return dao.getByUserID(id);
    }
}
