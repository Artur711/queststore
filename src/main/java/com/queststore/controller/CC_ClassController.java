package com.queststore.controller;

import com.queststore.model.CC_Class;
import com.queststore.model.Codecoolers;
import com.queststore.model.User;
import com.queststore.service.CC_ClassService;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.MentorService;
import org.springframework.jca.cci.core.support.CciDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
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
    public String addClassTest(Model model, CC_Class cc_class) {
        model.addAttribute("cc_class", new CC_Class());


        List<User> membersList = mentorService.getAllMentors();
        System.out.println(membersList);
        model.addAttribute("mentorsList", membersList);
//
////        Casting Students into Mentors in order to make action on one list instead of two while creating
//        List<User> studentsList;
//        studentsList = Collections.unmodifiableList(codeCoolerService.getAll());
//        membersList.addAll(studentsList);
//
//        CC_Class newClass = new CC_Class("dupa dupa", membersList);
//        classService.create(newClass);
        return "add_new_class";
    }

    @PostMapping("/add_class")
    public String addTheClass(Model model, @Valid CC_Class cc_class){
        classService.create(cc_class);
        return "add_new_class";
    }

    @GetMapping("/delete_class/{id}")
    public String deleteTheClass(@PathVariable("id") Integer id, Model model){
        classService.deleteTheClass(id);
        return "add_new_class";
    }

}
