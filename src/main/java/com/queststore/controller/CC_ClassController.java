package com.queststore.controller;

import com.queststore.model.CC_Class;
import com.queststore.model.Codecoolers;
import com.queststore.model.User;
import com.queststore.service.CC_ClassService;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.MentorService;
import org.springframework.jca.cci.core.support.CciDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class CC_ClassController {

    CC_ClassService classService;
    MentorService mentorService;
    CodeCoolerService codeCoolerService;
    List<User> listOfChosenMentors;
    List<Codecoolers> listOfChosenStudents;
    public CC_ClassController(CC_ClassService classService, MentorService mentorservice, CodeCoolerService codeCoolerService) {
        this.classService = classService;
        this.mentorService = mentorservice;
        this.codeCoolerService = codeCoolerService;
        this.listOfChosenMentors = new ArrayList<>();
        this.listOfChosenStudents = new ArrayList<>();
    }

    @GetMapping("/add_class")
    public String addClassTest(Model model, CC_Class cc_class) {
        model.addAttribute("cc_class", new CC_Class());
        model.addAttribute("listOfChosenMentors", listOfChosenMentors);
        model.addAttribute("listOfChosenStudents", listOfChosenStudents);

        List<User> membersList = mentorService.getAllMentors();
        List<Codecoolers> studentsList = codeCoolerService.getAll();
        model.addAttribute("mentors", membersList);
        model.addAttribute("students", studentsList);
//
////        Casting Students into Mentors in order to make action on one list instead of two while creating
//        List<User> studentsList;
//        studentsList = Collections.unmodifiableList(codeCoolerService.getAll());
//        membersList.addAll(studentsList);
//
//        CC_Class newClass = new CC_Class("dupa dupa", membersList);
//        classService.create(newClass);
        return "add_new_class";
    }

    @GetMapping("/add_the_class")
    public String addChosenMembers(Model model, @Valid String user){
        Long userId = Long.parseLong(user);
        User chosenOne = mentorService.getMentorById(userId);
        listOfChosenMentors.add(chosenOne);
//        model.addAttribute("listOfChosenMentors", listOfChosenMentors);
        return "redirect:/add_class";
   }

   @GetMapping("/add_the_student_to_class")
   public String addChosenStudentToTempList(Model model, @Valid String student){
       Long studentId = Long.parseLong(student);
       Codecoolers chosenOne = codeCoolerService.getByUserID(studentId);
       listOfChosenStudents.add(chosenOne);
        return "redirect:/add_class";
   }

    @PostMapping("/add_the_class")
    public String addTheClass(Model model, @RequestParam(value = "name") String name){
        System.out.println(name);
//        listOfChosenMentors.addAll(Collections.unmodifiableList(listOfChosenStudents));
        classService.create(new CC_Class(name, listOfChosenMentors, listOfChosenStudents));
        listOfChosenMentors.clear();
        listOfChosenStudents.clear();
        return "redirect:/add_class";
    }

    @GetMapping("/delete_student/{id}")
    public String deleteChosenStudent(@PathVariable("id") long id){
        System.out.println(id);
        Codecoolers chosenOneToBeRemoved = codeCoolerService.getByUserID(id);
        listOfChosenStudents.removeIf(chosenOneToBeRemoved::equals);
        return "redirect:/add_class";
    }

    @GetMapping("/delete_user/{id}")
    public String deleteChosenMentor(@PathVariable("id") long id){
        System.out.println(id);
        User chosenOneToBeRemoved = mentorService.getMentorById(id);
        listOfChosenMentors.removeIf(chosenOneToBeRemoved::equals);
        return "redirect:/add_class";

    }

    @PostMapping("/add_class")
    public String addTheClass(Model model, @Valid CC_Class cc_class){
        classService.create(cc_class);
        return "add_new_class";
    }

    @GetMapping("/delete_class/{id}")
    public String deleteTheClass(@PathVariable("id") Integer id){
        classService.deleteTheClass(id);
        return "add_new_class";
    }

}
