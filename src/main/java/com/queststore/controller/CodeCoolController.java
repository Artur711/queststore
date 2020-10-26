package com.queststore.controller;

import com.queststore.service.CodeCoolerService;
import com.queststore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/codecool")
public class CodeCoolController {

    private UserService userService;
    private CodeCoolerService codeCoolerService;

    public CodeCoolController(UserService userService, CodeCoolerService codeCoolerService) {
        this.userService = userService;
        this.codeCoolerService = codeCoolerService;
    }

    @GetMapping
    public String getCodeCool(Model model) {
        model.addAttribute("mentors", userService.getAllMentors());
        model.addAttribute("students", codeCoolerService.getAll());
        return "other/codecool";
    }
}
