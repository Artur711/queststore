package com.queststore.controller;

import com.queststore.model.Codecoolers;
import com.queststore.service.CodecoolerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CodecoolerController {

    private CodecoolerService service;

    public CodecoolerController(CodecoolerService service) {
        this.service = service;
    }

    @GetMapping("/student_list")
    public String getStudentsList(Model model){
        model.addAttribute("students", service.getAll());
        return "student_list";
    }


    @GetMapping("/add_codecooler")
    public String addTheCodecooler(Codecoolers codecooler){
        return "add_codecooler";
    }

    @PostMapping("/add_codecooler")
        public String addCodecooler(Model model, @Valid Codecoolers codecoolers){
        service.create(codecoolers);
        model.addAttribute("codecoolers", service.getAll());
        return "redirect:/student_list";
    }
}
