package com.queststore.controller;

import com.queststore.service.CC_ClassService;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/codecool")
public class CodeCoolSchoolController {

    private UserService userService;
    private CodeCoolerService codeCoolerService;
    private CC_ClassService cc_classService;

    public CodeCoolSchoolController(UserService userService, CodeCoolerService codeCoolerService, CC_ClassService cc_classService) {
        this.userService = userService;
        this.codeCoolerService = codeCoolerService;
        this.cc_classService = cc_classService;
    }

    @GetMapping
    public String getCodeCool() {
        return "other/codecool";
    }

    @GetMapping("/mentor_student")
    public String getMentorAndStudent(Model model) {
        model.addAttribute("mentors", userService.getAllMentors());
        model.addAttribute("students", codeCoolerService.getAll());
        return "other/mentors_students";
    }

    @GetMapping("/class_team")
    public String getClassesAndTeams(Model model) {
        model.addAttribute("classes", cc_classService.getAllClasses());
        return "other/class_team";
    }
}

