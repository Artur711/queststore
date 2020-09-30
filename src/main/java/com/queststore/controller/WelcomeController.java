package com.queststore.controller;

import com.queststore.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class WelcomeController {

    @GetMapping("/welcome_page")
    public String getWelcome(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("welcome", loggedUser);
        return "other/welcome_page";
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public String handler() {
        return "redirect:/index";
    }
}
