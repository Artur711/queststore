package com.queststore.controller;

import com.queststore.model.Codecoolers;
import com.queststore.model.User;
import com.queststore.service.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class QuestController {

    private QuestService service;

    public QuestController(QuestService service) {
        this.service = service;
    }

    @GetMapping("/quests_menu")
    public String chooseQuestsType() {
        return "store/quests_menu";
    }


    @GetMapping("/quests_store/{type}")
    public String getQuestList(@PathVariable("type") int type, Model model){
        model.addAttribute("quests", service.getAll());
        return "store/quests_store";
    }
}
