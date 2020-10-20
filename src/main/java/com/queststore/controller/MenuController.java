package com.queststore.controller;

import com.queststore.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String getMenu(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("user", loggedUser);
        return "menu/menu";
    }

    @GetMapping("/welcome_page")
    public String getWelcome(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("welcome", loggedUser);
        return "menu/welcome_page";
    }
}
