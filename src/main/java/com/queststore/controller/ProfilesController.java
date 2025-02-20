package com.queststore.controller;

import com.queststore.model.CodeCooler;
import com.queststore.model.User;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.ExperienceService;
import com.queststore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfilesController {

    private UserService mentorService;
    private CodeCoolerService codeCoolerService;
    private ExperienceService experienceService;

    public ProfilesController(UserService mentorService, CodeCoolerService codeCoolerService, ExperienceService experienceService) {
        this.mentorService = mentorService;
        this.codeCoolerService = codeCoolerService;
        this.experienceService = experienceService;
    }

    @GetMapping("/mentor_profile")
    public String getMentorProfile(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("profile", loggedUser);
        return "mentor/mentor_profile_page";
    }

    @PostMapping("/update_mentor_profile")
    public String updateMentorProfile(Model model, User user, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("loggedUser", setUserUpdate(loggedUser, user));
        return "redirect:/profile/mentor_profile";
    }

    @GetMapping("/admin_profile")
    public String getAdminProfile(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("profile", loggedUser);
        return "admin/admin_profile_page";
    }

    @PostMapping("/update_admin_profile")
    public String updateAdminProfile(Model model, User user, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("loggedUser", setUserUpdate(loggedUser, user));
        return "redirect:/profile/admin_profile";
    }

    @GetMapping("/codecooler_profile")
    public String getCodecoolerProfile(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        CodeCooler codeCooler = codeCoolerService.getCodeCoolerById(loggedUser.getUserId());
        model.addAttribute("profile", loggedUser);
        model.addAttribute("codecooler", codeCooler);
        model.addAttribute("loe", experienceService.getLevel(codeCooler.getExp()));
        return "codecooler/codecooler_profile_page";
    }

    @PostMapping("/update_codecooler_profile")
    public String updateCodeCoolerProfile(Model model, User user, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("loggedUser", setUserUpdate(loggedUser, user));
        return "redirect:/profile/codecooler_profile";
    }

    private User setUserUpdate(User loggedUser, User user) {
        loggedUser.setPhoneNumber(user.getPhoneNumber());
        loggedUser.setPassword(user.getPassword());
        loggedUser.setEmail(user.getEmail());
        mentorService.saveMentor(loggedUser);
        return loggedUser;
    }
}
