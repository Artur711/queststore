package com.queststore.controller;

import com.queststore.service.CodecoolerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CodecoolerController {

    private CodecoolerService service;

    public CodecoolerController(CodecoolerService service) {
        this.service = service;
    }

    @GetMapping("/student_list")
    public String getStudentsList(Model model){
        model.addAttribute("students", service.testFindAll());
        return "students_list";
    }
}
