package com.queststore.controller;

import com.queststore.model.User;
import com.queststore.service.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admins_list")
public class AdminController {

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allMentorsList(Model model){
        model.addAttribute("admins", userService.getAllAdmins());
        return "admin/admins_list";
    }

    @GetMapping("/add_admin")
    public String addNewMentor(Model model, User user){
        model.addAttribute("user", user);
        return "admin/add_admin";
    }

    @PostMapping("/add_admin")
    public String addTheMentor(Model model, @Valid User user){
        userService.saveAdmin(user);
        return "redirect:/admins_list";
    }

    @GetMapping("/admin_edit/{id}")
    public String mentorEdition(@PathVariable("id") long id, Model model){
        User admin = userService.getUserById(id);
        model.addAttribute("user", admin);
        return "admin/update_admin";
    }

    @PostMapping("/admin_edit/{id}")
    public String updateTheMentor(@PathVariable("id") long id, @Valid User admin){
        admin.setUserId(id);
        userService.saveAdmin(admin);
        return "redirect:/admins_list";
    }

    @GetMapping("/admin_delete/{id}")
    public String deleteTheMentor(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/admins_list";
    }
}
