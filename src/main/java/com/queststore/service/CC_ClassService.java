package com.queststore.service;

import com.queststore.model.CC_Class;
import com.queststore.model.CodeCooler;
import com.queststore.model.User;
import com.queststore.repository.CC_ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CC_ClassService {
    private CC_ClassRepository repository;

    public CC_ClassService(CC_ClassRepository repository) {
        this.repository = repository;
    }

    public void create(CC_Class cc_class, List<User> users, List<CodeCooler> codecoolers) {
        repository.save(cc_class);
        CC_Class cc = repository.getCC_ClassByName(cc_class.getName());
        users.addAll(codecoolers);
        for (User person : users
        ) {
            repository.insertUsertoClassroom(cc_class.getClassId(), person.getUserId());
        }
    }

    public void deleteTheClass(Long id) {

        repository.deleteById(id);
    }

    public List<CC_Class> getAllClasses() {
        return repository.findAll();
    }
}
