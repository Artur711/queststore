package com.queststore.service;

import com.queststore.dao.CC_classDAO;
import com.queststore.dao.CC_classJDBCDAO;
import com.queststore.model.CC_Class;
import com.queststore.repository.CC_ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CC_ClassService {
//    CC_classDAO classDAO;
    private CC_ClassRepository repository;

    public CC_ClassService(CC_ClassRepository repository) {
        this.repository = repository;
    }

    public void create(CC_Class cc_class){
        repository.save(cc_class);
    }

    public void deleteTheClass(Long id){

        repository.deleteById(id);
    }

    public List<CC_Class> getAllClasses(){
       return repository.findAll();
    }
}
