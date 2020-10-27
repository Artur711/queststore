package com.queststore.service;

import com.queststore.model.CC_Class;
import com.queststore.model.CodeCooler;
import com.queststore.model.User;
import com.queststore.repository.CC_ClassRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CC_ClassService {
    private CC_ClassRepository repository;
    private UserService userService;
    private CodeCoolerService codeCoolerService;

    public CC_ClassService(CC_ClassRepository repository, UserService userService, CodeCoolerService codeCoolerService) {
        this.repository = repository;
        this.userService = userService;
        this.codeCoolerService = codeCoolerService;
    }

    public void ClassToBeUpdate(CC_Class cc_class, List<User> users, List<CodeCooler> codecoolers) {
        repository.removeOldMembersFromClassToBeUpdated(cc_class.getClassId());
        create(cc_class, users, codecoolers);
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

    public CC_Class findCC_ClassById(Long classId) {
        return repository.findByClassId(classId);
    }

    public List<User> getUsersFromTheClass(Long class_id, Integer user_type) {
        List<Integer> usersId = repository.getUserIdFromTheClassroomAndUserType(class_id, user_type);
        List<User> usersFromTheClass = new ArrayList<>();
        usersId.stream().collect(Collectors.toSet()).forEach(userId -> {
            if (user_type == 2) {
                usersFromTheClass.add(userService.getUserById(userId));
            } else if (user_type == 1) {
                usersFromTheClass.add(codeCoolerService.getCodeCoolerById(userId));
            }
        });
        return usersFromTheClass;
    }

    public List<Long> getClassIdsOfUser(Long userId){
       return repository.getAllClassesIdOfTheUser(userId);
    }

    public List<CC_Class> getClassesByIds(List<Long> classesId){
         return repository.findAllByClassIdIn(classesId);
    }
}
