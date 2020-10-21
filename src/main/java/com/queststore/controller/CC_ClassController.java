package com.queststore.controller;

import com.queststore.model.CC_Class;
import com.queststore.model.CodeCooler;
import com.queststore.model.User;
import com.queststore.service.CC_ClassService;
import com.queststore.service.CodeCoolerService;
import com.queststore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/all_classes")
public class CC_ClassController {

    CC_ClassService classService;
    UserService userService;
    CodeCoolerService codeCoolerService;
    HttpSession session;

    public CC_ClassController(HttpSession session, CC_ClassService classService, UserService mentorservice, CodeCoolerService codeCoolerService) {
        this.session = session;
        this.classService = classService;
        this.userService = mentorservice;
        this.codeCoolerService = codeCoolerService;
    }

    @GetMapping
    public String getListOfAllClasses(Model model, HttpSession session) {
        List<CC_Class> allClass = classService.getAllClasses();
        model.addAttribute("allClasses", allClass);
        return "collaboration/my_class_list";
    }


    @GetMapping("/add_class")
    public String addClass(Model model, CC_Class cc_class, HttpServletRequest request) {
        session = request.getSession(false);
        model.addAttribute("cc_class", new CC_Class());
        User user = (User) session.getAttribute("loggedUser");
        model.addAttribute("listOfChosenMentors", session.getAttribute(String.format("listOfChosenMentors_%s", user.getUserId())));
        model.addAttribute("listOfChosenStudents", session.getAttribute(String.format("listOfChosenStudents_%s", user.getUserId())));

        List<User> membersList = userService.getAllMentors();
        List<CodeCooler> studentsList = codeCoolerService.getAll();
        model.addAttribute("mentors", membersList);
        model.addAttribute("students", studentsList);
        return "collaboration/add_new_class";
    }

    @GetMapping("/add_the_class")
    public String addChosenMentorsToTempList(Model model, @Valid String user, HttpSession session, @SessionAttribute("loggedUser") User loggedUser) {

        Long userId = Long.parseLong(user);
        User chosenOne = userService.getUserById(userId);
        List<User> tempList = (List<User>) session.getAttribute(String.format("listOfChosenMentors_%s", loggedUser.getUserId()));
        tempList.add(chosenOne);
        session.setAttribute(String.format("listOfChosenMentors_%s", loggedUser.getUserId()), tempList);
        return "redirect:/all_classes/add_class";
    }

    @GetMapping("/add_the_student_to_class")
    public String addChosenStudentToTempList(Model model, @Valid String student, HttpSession session, @SessionAttribute("loggedUser") User loggedUser) {
        Long studentId = Long.parseLong(student);
        CodeCooler chosenOne = codeCoolerService.getCodeCoolerById(studentId);

        List<User> tempList = (List<User>) session.getAttribute(String.format("listOfChosenStudents_%s", loggedUser.getUserId()));
        tempList.add(chosenOne);
        session.setAttribute(String.format("listOfChosenStudents_%s", loggedUser.getUserId()), tempList);
        return "redirect:/all_classes/add_class";
    }

    //   CDN
    @PostMapping("/add_the_class")
    public String addTheClass(Model model, @RequestParam(value = "name") String name, @SessionAttribute("loggedUser") User loggedUser) {
        System.out.println(name);
        List<User> mentorsList = (List<User>) session.getAttribute(String.format("listOfChosenMentors_%s", loggedUser.getUserId()));
        List<CodeCooler> codecoolersList = (List<CodeCooler>) session.getAttribute(String.format("listOfChosenStudents_%s", loggedUser.getUserId()));

        classService.create(new CC_Class(name), mentorsList, codecoolersList);
        mentorsList.clear();
        codecoolersList.clear();
        session.setAttribute((String.format("listOfChosenMentors_%s", loggedUser.getUserId())), mentorsList);
        session.setAttribute((String.format("listOfChosenStudents_%s", loggedUser.getUserId())), codecoolersList);
        return "redirect:/all_classes";
    }

    @GetMapping("/delete_student/{id}")
    public String deleteChosenStudent(@PathVariable("id") long id, @SessionAttribute("loggedUser") User loggedUser) {
        System.out.println(id);
        CodeCooler chosenOneToBeRemoved = codeCoolerService.getCodeCoolerById(id);
        List<CodeCooler> codecoolersList = (List<CodeCooler>) session.getAttribute(String.format("listOfChosenStudents_%s", loggedUser.getUserId()));
        codecoolersList.removeIf(chosenOneToBeRemoved::equals);
        session.setAttribute((String.format("listOfChosenStudents_%s", loggedUser.getUserId())), codecoolersList);
        return "redirect:/all_classes/add_class";
    }

    @GetMapping("/delete_user/{id}")
    public String deleteChosenMentor(@PathVariable("id") long id, @SessionAttribute("loggedUser") User loggedUser) {
        System.out.println(id);
        User chosenOneToBeRemoved = userService.getUserById(id);
        List<User> mentorsList = (List<User>) session.getAttribute(String.format("listOfChosenMentors_%s", loggedUser.getUserId()));
        mentorsList.removeIf(chosenOneToBeRemoved::equals);
        session.setAttribute((String.format("listOfChosenMentors_%s", loggedUser.getUserId())), mentorsList);
        return "redirect:/all_classes/add_class";

    }

    @GetMapping("/delete_class/{id}")
    public String deleteTheClass(@PathVariable("id") Long id) {
        classService.deleteTheClass(id);
        return "redirect:/all_classes";
    }

    @GetMapping("/edit_class/{id}")
    public String editiTheClass(@PathVariable("id") Long classId){
        System.out.println(classId);
        return "collaboration/edit_the_class";
    }
}
