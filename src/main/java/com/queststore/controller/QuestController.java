package com.queststore.controller;

import com.queststore.model.Item;
import com.queststore.model.Quest;
import com.queststore.model.User;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuestController {

    private final CodeCoolerService codeService;
    private QuestService service;

    public QuestController(QuestService service, CodeCoolerService codeService) {

        this.service = service;
        this.codeService = codeService;
    }

    @GetMapping("/quests_menu")
    public String chooseQuestsType() {
        return "store/quests_menu";
    }


    @GetMapping("/quests_store/{type}")
    public String getQuestList(@PathVariable("type") int type, @SessionAttribute("loggedUser") User loggedUser, Model model){
        model.addAttribute("quests", service.getUniqueQuests(loggedUser.getUserId()));
        return "store/quests_store";
    }

    @PostMapping("/complete_quest")
    public String complateQuest(Model model, @SessionAttribute("loggedUser") User loggedUser, @RequestParam(value = "questId") long questId) {

        model.addAttribute("id", codeService.getCodeCoolerById(loggedUser.getUserId()));

        int studentCoins =  codeService.getCodeCoolerById(loggedUser.getUserId()).getCodeCoolCoins();
        int questPrice = service.getById(questId).getQuestValue();
        long loggedUserId = loggedUser.getUserId();

        service.completeQuest(loggedUserId, questId);
        codeService.updateCoinsBalance((studentCoins + questPrice),loggedUserId);
        return "redirect:/quests_menu";
    }

    @GetMapping("/my_quests")
    public String getMyItemsList(@SessionAttribute("loggedUser") User loggedUser, Model model) {
        model.addAttribute("codecoolerQuests", service.getCodecoolerQuests(loggedUser.getUserId()));
        return "inventory/my_quests_list";
    }

    @GetMapping("/quest_list")
    public String getItemsList(Model model){
        model.addAttribute("quests", service.getAll());
        return "inventory/quest_list";
    }
}
