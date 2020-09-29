package com.queststore.controller;

import com.queststore.dao.UserLoginJDBCDAO;
import com.queststore.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loggedUser")
public class LoginController {

    private UserLoginJDBCDAO userLoginJDBCDAO;

    public LoginController(UserLoginJDBCDAO userLoginJDBCDAO) {
        this.userLoginJDBCDAO = userLoginJDBCDAO;
    }

    @GetMapping("/index")
    public String login(Model model, User user) {
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping
    public String postLogin(Model model, @ModelAttribute("user") User user) {
        User loggedUser = userLoginJDBCDAO.getUser(user.getLastName(), user.getPassword());
        model.addAttribute("loggedUser", loggedUser);

        if (loggedUser != null) {
            if (loggedUser.getUserType() == 3) {
                return "redirect:/mentor_menu";
            } else if (loggedUser.getUserType() == 2) {
                return "redirect:/mentor_menu";
            } else if (loggedUser.getUserType() == 1) {
                return "redirect:/codecooler_menu";
            }
        }
        return "index";
    }
}
