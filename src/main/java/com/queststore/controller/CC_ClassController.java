package com.queststore.controller;

import com.queststore.model.CC_Class;
import com.queststore.model.Codecoolers;
import com.queststore.model.User;
import com.queststore.service.CC_ClassService;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.MentorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CC_ClassController {

    CC_ClassService classService;
    MentorService mentorService;
    CodeCoolerService codeCoolerService;

    public CC_ClassController(CC_ClassService classService, MentorService mentorservice, CodeCoolerService codeCoolerService) {
        this.classService = classService;
        this.mentorService = mentorservice;
        this.codeCoolerService = codeCoolerService;
    }

    @GetMapping("/add_class")
    public String addClassTest(Model model){
        List<User> mentorsList = mentorService.getAllMentors();
        List<Codecoolers> studentsList = codeCoolerService.getAll();
        CC_Class newClass = new CC_Class("dupa dupa", mentorsList, studentsList);
        classService.create(newClass);
        return "add_new_class";
    }
}
