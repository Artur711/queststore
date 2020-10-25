package com.queststore.controller;

import com.queststore.model.Item;
import com.queststore.model.Quest;
import com.queststore.model.User;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String getQuestList(@PathVariable("type") int type, @SessionAttribute("loggedUser") User loggedUser, Model model) {
        model.addAttribute("quests", service.getUniqueQuests(loggedUser.getUserId()));
        return "store/quests_store";
    }

    @PostMapping("/complete_quest")
    public String complateQuest(Model model, @SessionAttribute("loggedUser") User loggedUser, @RequestParam(value = "questId") long questId) {

        model.addAttribute("id", codeService.getCodeCoolerById(loggedUser.getUserId()));

        int studentCoins = codeService.getCodeCoolerById(loggedUser.getUserId()).getCodeCoolCoins();
        int questPrice = service.getById(questId).getQuestValue();
        long loggedUserId = loggedUser.getUserId();

        service.completeQuest(loggedUserId, questId);
        codeService.updateCoinsBalance((studentCoins + questPrice), loggedUserId);
        return "redirect:/quests_menu";
    }

    @GetMapping("/my_quests")
    public String getMyItemsList(@SessionAttribute("loggedUser") User loggedUser, Model model) {
        model.addAttribute("codecoolerQuests", service.getCodecoolerQuests(loggedUser.getUserId()));
        return "inventory/my_quests_list";
    }

    @GetMapping("/quest_list")
    public String getItemsList(Model model) {
        model.addAttribute("quests", service.getAll());
        return "inventory/quest_list";
    }

    @GetMapping("/edit_quest/{id}")
    public String editQuest(@PathVariable("id") long id, Model model) {
        Quest quest = service.getById(id);
        model.addAttribute("quest", quest);
        return "inventory/edit_quest";
    }

    @GetMapping("/delete_quest/{id}")
    public String removeQuest(@PathVariable("id") long id, Model model) {
        service.delete(id);
        model.addAttribute("quests", service.getAll());
        return "redirect:/quest_list";
    }

    @GetMapping("/add_new_quest")
    public String addNewQuest(Model model, Quest quest){
        model.addAttribute("quest", quest);
        return "store/add_new_quest";
    }

    @PostMapping("/add_new_quest")
    public String addQuest(Model model, @Valid Quest quest){
        quest.setImg("/../photo/img/logo-menu/logo-menu6.jpg");
        service.save(quest);
        model.addAttribute("quests", service.getAll());
        return "redirect:/quest_list";
    }

    @PostMapping("/update_quest/{id}")
    public String updateQuest(@PathVariable("id") long id, @Valid Quest quest, BindingResult result) {
        if (result.hasErrors()) {
            return "inventory/edit_quest";
        }
        quest.setQuestId(id);
        service.save(quest);

        return "redirect:/quest_list";
    }
}
