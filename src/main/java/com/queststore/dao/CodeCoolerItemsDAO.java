package com.queststore.dao;

import com.queststore.model.CodeCoolerItems;

import java.util.List;

public interface CodeCoolerItemsDAO {

    List<CodeCoolerItems> getAll();

    List<CodeCoolerItems> getByCodeCoolerID(long id);

    void markUsedItem(long id);
}
