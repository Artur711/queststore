package com.queststore.controller;

import com.queststore.service.ExperienceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExperienceController {

    private final ExperienceService service;

    public ExperienceController(ExperienceService service) {
        this.service = service;
    }

    @GetMapping("/experiences")
    public String getExperience(Model model) {
        model.addAttribute("experience", service.getExperience());
        return "other/experiences_levels";
    }
}
