package com.queststore.controller;

import com.queststore.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MenuController {

    @GetMapping("/admin_menu")
    public String getAdminMenu() {
        return "menu/admin_menu";
    }

    @GetMapping("/mentor_menu")
    public String getMentorMenu() {
        return "menu/mentor_menu";
    }

    @GetMapping("/codecooler_menu")
    public String getCodeCoolerMenu() {
        return "menu/codecooler_menu";
    }

    @GetMapping("/welcome_page")
    public String getWelcome(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("welcome", loggedUser);
        return "other/welcome_page";
    }
}
