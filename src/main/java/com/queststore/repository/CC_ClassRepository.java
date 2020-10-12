package com.queststore.repository;

import com.queststore.model.CC_Class;
import com.queststore.model.Item;
import com.queststore.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CC_ClassRepository extends CrudRepository<CC_Class, Long> {

    List<CC_Class> findAll();

    CC_Class save(CC_Class cc_class);

    @Override
    void deleteById(Long id);

//    void deleteCC_ClassByClassId(Long id);


}
