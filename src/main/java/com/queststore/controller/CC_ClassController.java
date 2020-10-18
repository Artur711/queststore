package com.queststore.controller;

import com.queststore.model.CC_Class;
import com.queststore.model.CodeCooler;
import com.queststore.model.User;
import com.queststore.service.CC_ClassService;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.UserService;
import org.hibernate.service.spi.SessionFactoryServiceInitiatorContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.validation.Valid;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CC_ClassController {

    CC_ClassService classService;
    UserService userService;
    CodeCoolerService codeCoolerService;
//    List<User> listOfChosenMentors;
//    List<CodeCooler> listOfChosenStudents;
    HttpSession session;

    public CC_ClassController(HttpSession session, CC_ClassService classService, UserService mentorservice, CodeCoolerService codeCoolerService) {
        this.session = session;
        this.classService = classService;
        this.userService = mentorservice;
        this.codeCoolerService = codeCoolerService;
//        this.listOfChosenMentors = new ArrayList<>();
//        this.listOfChosenStudents = new ArrayList<>();

    }

    @GetMapping("/all_classes")
    public String getListOfAllClasses(Model model, HttpSession session) {
        List<CC_Class> allClass = classService.getAllClasses();
        model.addAttribute("allClasses", allClass);

        session.setAttribute("listOfChosenMentors", new ArrayList<User>());
        session.setAttribute("listOfChosenStudents",new ArrayList<User>());

        return "collaboration/my_class_list";
    }


    @GetMapping("/add_class")
    public String addClassTest(Model model, CC_Class cc_class, HttpServletRequest request) {
        session = request.getSession(false);
        model.addAttribute("cc_class", new CC_Class());
        model.addAttribute("listOfChosenMentors", session.getAttribute("listOfChosenMentors"));
        model.addAttribute("listOfChosenStudents", session.getAttribute("listOfChosenStudents"));

        List<User> membersList = userService.getAllMentors();
        List<CodeCooler> studentsList = codeCoolerService.getAll();
        model.addAttribute("mentors", membersList);
        model.addAttribute("students", studentsList);
        return "collaboration/add_new_class";
    }

    @GetMapping("/add_the_class")
    public String addChosenMentors(Model model, @Valid String user, HttpSession session, @SessionAttribute(value = "listOfChosenMentors") List<User> tempo) {

        Long userId = Long.parseLong(user);
        User chosenOne = userService.getUserById(userId);
          List<User>tempList = (List<User>) session.getAttribute("listOfChosenMentors");
        tempo.add(chosenOne);
//        Object listOfChosenMentors = model.getAttribute("listOfChosenMentors");
//        tempList.add(chosenOne);
//        model.addAttribute("listOfChosenMentors",listOfChosenMentors);
          session.setAttribute("listOfChosenMentors",tempo);
        return "redirect:/add_class";
    }

    @GetMapping("/add_the_student_to_class")
    public String addChosenStudentToTempList(Model model, @Valid String student, HttpSession session) {
        Long studentId = Long.parseLong(student);
        CodeCooler chosenOne = codeCoolerService.getCodeCoolerById(studentId);

        List<User>tempList = (List<User>) session.getAttribute("listOfChosenStudents");
        tempList.add(chosenOne);
        session.setAttribute("listOfChosenStudents",tempList);

//        listOfChosenStudents.add(chosenOne);
        return "redirect:/add_class";
    }

    //   CDN
    @PostMapping("/add_the_class")
    public String addTheClass(Model model, @RequestParam(value = "name") String name) {
        System.out.println(name);
//        classService.create(new CC_Class(name), listOfChosenMentors, listOfChosenStudents);
//        listOfChosenMentors.clear();
//        listOfChosenStudents.clear();
        return "redirect:/all_classes";
    }

    @GetMapping("/delete_student/{id}")
    public String deleteChosenStudent(@PathVariable("id") long id) {
        System.out.println(id);
        CodeCooler chosenOneToBeRemoved = codeCoolerService.getCodeCoolerById(id);
//        listOfChosenStudents.removeIf(chosenOneToBeRemoved::equals);
        return "redirect:/add_class";
    }

    @GetMapping("/delete_user/{id}")
    public String deleteChosenMentor(@PathVariable("id") long id) {
        System.out.println(id);
        User chosenOneToBeRemoved = userService.getUserById(id);
//        listOfChosenMentors.removeIf(chosenOneToBeRemoved::equals);
        return "redirect:/add_class";

    }

    @GetMapping("/delete_class/{id}")
    public String deleteTheClass(@PathVariable("id") Long id) {
        classService.deleteTheClass(id);
        return "redirect:/all_classes";
    }

}
