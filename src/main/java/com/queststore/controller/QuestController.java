package com.queststore.controller;

import com.queststore.service.CodecoolerService;
import com.queststore.service.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestController {

    private QuestService service;

    public QuestController(QuestService service) {
        this.service = service;
    }

    @GetMapping("/quest_store")
    public String getSingleQuestList(Model model){
        model.addAttribute("quests", service.getAll());
        return "quest_store";
    }
}
