package com.queststore.dao;

import com.queststore.model.Codecoolers;

import java.util.List;

public interface CodeCoolerDAO {
    void create(Codecoolers codecoolers);

    void update(Codecoolers codecoolers);

    List<Codecoolers> getAll();

    void delete(Long id);

    Codecoolers getByID(Long id);
}
