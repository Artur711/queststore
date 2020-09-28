package com.queststore.service;

import com.queststore.dao.CodeCoolerDAO;
import com.queststore.model.Codecoolers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodecoolerService {
    private CodeCoolerDAO dao;


    public CodecoolerService(CodeCoolerDAO dao) {
        this.dao = dao;
    }

    public void create(Codecoolers codecooler) {
       dao.create(codecooler);
    }

    public void update(Codecoolers codecooler) {
        dao.update(codecooler);
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
}
