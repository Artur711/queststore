package com.queststore.dao;

import com.queststore.model.Codecoolers;

import java.util.List;

public interface CodecoolerDAO {
    public int addCodecooler(Codecoolers codecooler);
    void create(Codecoolers codecoolers);

    void update(Codecoolers codecoolers);

    List<Codecoolers> getAll();

    void delete(Long id);
}
