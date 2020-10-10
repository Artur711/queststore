package com.queststore.repository;

import com.queststore.model.CodeCoolerItems;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CodeCoolerItemsRepository extends CrudRepository<CodeCoolerItems, Long> {

    CodeCoolerItems save(CodeCoolerItems items);

    List<CodeCoolerItems> findAll();
}
