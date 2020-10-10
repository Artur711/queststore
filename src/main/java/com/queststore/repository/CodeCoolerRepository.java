package com.queststore.repository;

import com.queststore.model.CodeCooler;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CodeCoolerRepository extends CrudRepository<CodeCooler, Long> {

    CodeCooler save(CodeCooler codeCooler);

    List<CodeCooler> findAll();

    void delete (CodeCooler codeCooler);
}
