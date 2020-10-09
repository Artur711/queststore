package com.queststore.service;

import com.queststore.dao.CC_classDAO;
import com.queststore.dao.CC_classJDBCDAO;
import com.queststore.model.CC_Class;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class CC_ClassService {
    CC_classDAO classDAO;

    public CC_ClassService(CC_classDAO classDAO) {
        this.classDAO = classDAO;
    }

    public void create(CC_Class cc_class){
        classDAO.create(cc_class);
    }

    public void deleteTheClass(Integer id){
        classDAO.delete(id);
    }

    public List<CC_Class> getAllClasses(){
       return classDAO.getAll();
    }
}
