package com.queststore.controller;

import com.queststore.model.Codecoolers;
import com.queststore.model.User;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.ItemService;
import com.queststore.service.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String getQuestList(@PathVariable("type") int type, Model model){
        model.addAttribute("quests", service.getAll());
        return "store/quests_store";
    }

    @PostMapping("/complete_quest")
    public String complateQuest(Model model, @SessionAttribute("loggedUser") User loggedUser, @RequestParam(value = "questId") long questId) {

        model.addAttribute("id", codeService.getByUserID(loggedUser.getUserId()));

        int studentCoins =  codeService.getByID(loggedUser.getUserId()).getCodecool_coins();
        int questPrice = service.getById(questId).getQuestValue();
        int loggedUserId = (int)loggedUser.getUserId();

        codeService.complateQuest(loggedUserId ,(studentCoins + questPrice), (int)questId);

        return "redirect:/welcome_page";
    }
}
