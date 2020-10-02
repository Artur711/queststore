package com.queststore.dao;

import com.queststore.model.CC_Class;

import java.util.List;

public interface CC_classDAO {

    void create(CC_Class cc_class);

    void delete(Integer id);

    void update(CC_Class cc_class);

    List<CC_Class> getAll();
}
