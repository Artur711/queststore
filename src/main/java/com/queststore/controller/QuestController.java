package com.queststore.controller;

import com.queststore.service.CodecoolerService;
import com.queststore.service.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestController {

    private QuestService service;

    public QuestController(QuestService service) {
        this.service = service;
    }

    @GetMapping("/quests_menu")
    public String chooseQuestsType() {
        return "quests_menu";
    }

    @GetMapping("/quests_store/{type}")
    public String getQuestList(@PathVariable("type") int type, Model model){
        System.out.println(type);
        model.addAttribute("type", type);
        model.addAttribute("quests", service.getAll());
        return "quests_store";
    }
}
