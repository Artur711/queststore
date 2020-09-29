package com.queststore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String userPage(Model model, HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
