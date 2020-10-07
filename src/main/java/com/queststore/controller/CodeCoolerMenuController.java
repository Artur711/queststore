package com.queststore.controller;

import com.queststore.model.User;
import com.queststore.service.CodeCoolerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CodeCoolerMenuController {

    private final CodeCoolerService service;

    public CodeCoolerMenuController(CodeCoolerService service) {
        this.service = service;
    }

    @GetMapping("/codecooler_menu")
    public String getMentorMenu(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("menu", service.getByUserID(loggedUser.getUserId()));
        return "menu/codecooler_menu";
    }
}
