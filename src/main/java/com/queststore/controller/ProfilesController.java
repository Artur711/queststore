package com.queststore.controller;

import com.queststore.model.Codecoolers;
import com.queststore.model.User;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.ExperienceService;
import com.queststore.service.MentorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfilesController {

    private MentorService mentorService;
    private CodeCoolerService codeCoolerService;
    private ExperienceService experienceService;

    public ProfilesController(MentorService mentorService, CodeCoolerService codeCoolerService, ExperienceService experienceService) {
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
        return "redirect:/mentor_profile";
    }

    @GetMapping("/admin_profile")
    public String getAdminProfile(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("profile", loggedUser);
        return "admin/admin_profile_page";
    }

    @PostMapping("/update_admin_profile")
    public String updateAdminProfile(Model model, User user, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("loggedUser", setUserUpdate(loggedUser, user));
        return "redirect:/admin_profile";
    }

    @GetMapping("/codecooler_profile")
    public String getCodecoolerProfile(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        Codecoolers codecoolers = codeCoolerService.getByUserID(loggedUser.getUserId());
        model.addAttribute("profile", loggedUser);
        model.addAttribute("codecooler", codecoolers);
        model.addAttribute("loe", experienceService.getLevel(codecoolers.getLoe_id()));
        return "codecooler/codecooler_profile_page";
    }

    @PostMapping("/update_codecooler_profile")
    public String updateCodeCoolerProfile(Model model, User user, @SessionAttribute("loggedUser") User loggedUser) {
        model.addAttribute("loggedUser", setUserUpdate(loggedUser, user));
        return "redirect:/codecooler_profile";
    }

    private User setUserUpdate(User loggedUser, User user) {
        loggedUser.setPhoneNumber(user.getPhoneNumber());
        loggedUser.setPassword(user.getPassword());
        loggedUser.setEmail(user.getEmail());
        mentorService.updateMentor(loggedUser);
        return loggedUser;
    }
}
