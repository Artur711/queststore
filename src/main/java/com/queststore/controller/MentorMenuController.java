package com.queststore.controller;

import com.queststore.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MentorMenuController {

    @GetMapping("/mentor_menu")
    public String getMentorMenu(Model model) {
        model.addAttribute("menu", null);
        return "menu/mentor_menu";
    }

}
