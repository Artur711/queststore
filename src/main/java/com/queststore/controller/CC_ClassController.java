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
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/all_classes")
public class CC_ClassController {

    private CC_ClassService classService;
    private UserService userService;
    private CodeCoolerService codeCoolerService;
    private HttpSession session;

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
        // need for updating class
        session.removeAttribute("listOfChosenMentors");
        session.removeAttribute("listOfChosenStudents");

        return "collaboration/list_of_all_classes_list";
    }


    @GetMapping("/add_class")
    public String addClass(Model model, CC_Class cc_class, HttpServletRequest request) {
        session = request.getSession(false);
        model.addAttribute("cc_class", new CC_Class());
        User user = (User) session.getAttribute("loggedUser");
        model.addAttribute("listOfChosenMentors", new HashSet<User>((Collection<? extends User>) session.getAttribute(String.format("listOfChosenMentors_%s", user.getUserId()))));
        model.addAttribute("listOfChosenStudents", new HashSet<User>((Collection<? extends User>) session.getAttribute(String.format("listOfChosenStudents_%s", user.getUserId()))));

        List<User> membersList = userService.getAllMentors();
        List<CodeCooler> studentsList = codeCoolerService.getAll();
        model.addAttribute("mentors", membersList);
        model.addAttribute("students", studentsList);
        return "collaboration/add_new_class";
    }

    @GetMapping("/add_mentor_to_new_class")
    public String addChosenMentorsToTempList(Model model, @Valid User user, HttpSession session, @SessionAttribute("loggedUser") User loggedUser) {
        List<User> tempList = (List<User>) session.getAttribute(String.format("listOfChosenMentors_%s", loggedUser.getUserId()));
        if (!tempList.contains(user)) {
            tempList.add(user);
        }
        session.setAttribute(String.format("listOfChosenMentors_%s", loggedUser.getUserId()), tempList);
        return "redirect:/all_classes/add_class";
    }

    @GetMapping("/add_the_student_to_class")
    public String addChosenStudentToTempList(Model model, @Valid String student, HttpSession session, @SessionAttribute("loggedUser") User loggedUser) {
        Long studentId = Long.parseLong(student);
        CodeCooler chosenOne = codeCoolerService.getCodeCoolerById(studentId);

        List<User> tempList = (List<User>) session.getAttribute(String.format("listOfChosenStudents_%s", loggedUser.getUserId()));
        if (!tempList.contains(chosenOne)) {
            tempList.add(chosenOne);
        }
        session.setAttribute(String.format("listOfChosenStudents_%s", loggedUser.getUserId()), tempList);
        return "redirect:/all_classes/add_class";
    }

    @PostMapping("/add_the_class")
    public String addTheClass(Model model, @RequestParam(value = "name") String name, @SessionAttribute("loggedUser") User loggedUser) {
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
        CodeCooler chosenOneToBeRemoved = codeCoolerService.getCodeCoolerById(id);
        List<CodeCooler> codecoolersList = (List<CodeCooler>) session.getAttribute(String.format("listOfChosenStudents_%s", loggedUser.getUserId()));
        codecoolersList.removeIf(chosenOneToBeRemoved::equals);
        session.setAttribute((String.format("listOfChosenStudents_%s", loggedUser.getUserId())), codecoolersList);
        return "redirect:/all_classes/add_class";
    }

    @GetMapping("/delete_user/{id}")
    public String deleteChosenMentor(@PathVariable("id") long id, @SessionAttribute("loggedUser") User loggedUser) {
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

    @PostMapping("add_the_edited_class/{id}")
    public String addTheEditedClass(HttpSession session, @PathVariable("id") Long classId, @RequestParam(value = "name") String name) {
        HashSet<User> setOfChosenMentors = (HashSet<User>) session.getAttribute("listOfChosenMentors");
        HashSet<CodeCooler> setOfChosenStudents = (HashSet<CodeCooler>) session.getAttribute("listOfChosenStudents");

        List<User> mentorsToBeSaved = new ArrayList<>(setOfChosenMentors);
        List<CodeCooler> StudentsToBeSaved = new ArrayList<>(setOfChosenStudents);
        classService.ClassToBeUpdate(new CC_Class(classId, name), mentorsToBeSaved, StudentsToBeSaved);
        return "redirect:/all_classes";
    }

    @GetMapping("/edit_class/{id}")
    public String editTheClass(Model model, @PathVariable("id") Long classId, HttpSession session) {
        Integer mentorType = 2;
        Integer studentType = 1;
        CC_Class cc_classById = classService.findCC_ClassById(classId);
        model.addAttribute("cc_class", cc_classById);
        model.addAttribute("mentors", userService.getAllMentors());
        model.addAttribute("students", codeCoolerService.getAll());

        HashSet<User> setOfChosenMentors = (HashSet<User>) session.getAttribute("listOfChosenMentors");
        if (setOfChosenMentors == null) {
            session.setAttribute("listOfChosenMentors", new HashSet<>(classService.getUsersFromTheClass(classId, mentorType)));
            model.addAttribute("listOfChosenMentors", classService.getUsersFromTheClass(classId, mentorType));
        } else {
            model.addAttribute("listOfChosenMentors", setOfChosenMentors);
        }
        HashSet<User> setOfChosenStudents = (HashSet<User>) session.getAttribute("listOfChosenStudents");
        if (setOfChosenStudents == null) {
            session.setAttribute("listOfChosenStudents", new HashSet<>(classService.getUsersFromTheClass(classId, studentType)));
            model.addAttribute("listOfChosenStudents", classService.getUsersFromTheClass(classId, studentType));
        } else {
            model.addAttribute("listOfChosenStudents", setOfChosenStudents);
        }
        return "collaboration/edit_the_class";
    }

    @GetMapping("/delete_mentor/{id}/{classId}")
    public String deleteMentorFromTheClass(Model model, @PathVariable("id") Long userId, @PathVariable("classId") Long classId, HttpSession session) {
        HashSet<User> setOfChosenMentors = (HashSet<User>) session.getAttribute("listOfChosenMentors");
        Set<User> updatedSet = setOfChosenMentors.stream().filter(user -> user.getUserId() != userId).collect(Collectors.toSet());
        session.setAttribute("listOfChosenMentors", updatedSet);
        String url = String.format("redirect:/all_classes/edit_class/%d", classId);
        return url;
    }


    @GetMapping("/delete_codecooler_from_edited_class/{id}/{classId}")
    public String deleteStudentFromTheClass(Model model, @PathVariable("id") Long userId, @PathVariable("classId") Long classId, HttpSession session) {
        HashSet<User> setOfChosenStudents = (HashSet<User>) session.getAttribute("listOfChosenStudents");
        Set<User> updatedSet = setOfChosenStudents.stream().filter(user -> user.getUserId() != userId).collect(Collectors.toSet());
        session.setAttribute("listOfChosenStudents", updatedSet);
        String url = String.format("redirect:/all_classes/edit_class/%d", classId);
        return url;
    }


    @GetMapping("/add_mentor_to_edit_class/{classId}")
    public String addMentorToTheClass(Model model, @Valid User user, @PathVariable("classId") Long classId, HttpSession session) {
        HashSet<User> setOfChosenMentors = (HashSet<User>) session.getAttribute("listOfChosenMentors");
        setOfChosenMentors.add(user);
        session.setAttribute("listOfChosenMentors", setOfChosenMentors);
        String url = String.format("redirect:/all_classes/edit_class/%d", classId);
        return url;
    }

    @GetMapping("/add_codecooler_to_edit_class/{classId}")
    public String addStudentToTheClass(Model model, @Valid String student, @PathVariable("classId") Long classId, HttpSession session) {
        HashSet<User> setOfChosenCodecoolers = (HashSet<User>) session.getAttribute("listOfChosenStudents");
        setOfChosenCodecoolers.add(codeCoolerService.getCodeCoolerById((Long.parseLong(student))));
        session.setAttribute("listOfChosenStudents", setOfChosenCodecoolers);
        String url = String.format("redirect:/all_classes/edit_class/%d", classId);
        return url;
    }

    @GetMapping("/my_class")
    public String getAllStudentsClasses(Model model, @SessionAttribute("loggedUser") User loggedUser) {
        List<Long> classesId = classService.getClassIdsOfUser(loggedUser.getUserId());
        List<CC_Class> allStudentsClasses = new ArrayList<>();
        for (Long classId : classesId
        ) {
            allStudentsClasses.add(classService.findCC_ClassById(classId));
        }
        model.addAttribute("listOfClasses", allStudentsClasses);
        return "collaboration/all_my_classes_list";
    }


    @GetMapping("/chosen_my_class/{id}")
    public String getListOfAllMembersOfStudentClass(@PathVariable("id") Long classId, Model model, @SessionAttribute("loggedUser") User loggedUser) {
        Integer mentorType = 2;
        Integer studentType = 1;
        List<User> mentorsFromTheClass = classService.getUsersFromTheClass(classId, mentorType);
        List<User> studentsFromTheClass = classService.getUsersFromTheClass(classId, studentType);

        HashMap<User, List<CC_Class>> objectObjectHashMap = new HashMap<>();
        for (User user : mentorsFromTheClass
        ) {
            objectObjectHashMap.put(user, classService.getClassesByIds(classService.getClassIdsOfUser(user.getUserId())));
        }
        model.addAttribute("listOfStudents", studentsFromTheClass);
        if (objectObjectHashMap.size() != 0) {
            model.addAttribute("mapOfMentors", objectObjectHashMap);
        }
        else {
            model.addAttribute("mapOfMentors", null);
        }

        return "collaboration/my_class_list";
    }
}
