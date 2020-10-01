package com.queststore.controller;

import com.queststore.model.User;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.MentorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ProfilesController {

    private MentorService mentorService;
    private CodeCoolerService codeCoolerService;

    public ProfilesController(MentorService mentorService, CodeCoolerService codeCoolerService) {
        this.mentorService = mentorService;
        this.codeCoolerService = codeCoolerService;
    }

    @GetMapping("/mentor_profile")
    public String getMentorProfile(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("profile", loggedUser);
        return "mentor/mentor_profile_page";
    }

    @PostMapping("/update_mentor_profile")
    public String updateMentorProfile(Model model, User user, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("loggedUser", setUserUpdate(loggedUser, user));
        mentorService.updateMentor(loggedUser);
        return "redirect:/mentor_profile";
    }

    @GetMapping("/codecooler_profile")
    public String getCodecoolerProfile(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("profile", loggedUser);
        model.addAttribute("codecooler", codeCoolerService.getByUserID(loggedUser.getUserId()));
        return "codecooler/codecooler_profile_page";
    }

    @PostMapping("/update_codecooler_profile")
    public String updateCodeCoolerProfile(Model model, User user, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("loggedUser", setUserUpdate(loggedUser, user));
        mentorService.updateMentor(loggedUser);
        return "redirect:/codecooler_profile";
    }

    private User setUserUpdate(User loggedUser, User user) {
        loggedUser.setPhoneNumber(user.getPhoneNumber());
        loggedUser.setPassword(user.getPassword());
        loggedUser.setEmail(user.getEmail());
        return loggedUser;
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public String handle() {
        return "redirect:/index";
    }
}
