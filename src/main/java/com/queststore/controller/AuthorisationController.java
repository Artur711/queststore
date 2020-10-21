package com.queststore.controller;

import com.queststore.model.User;
import com.queststore.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AuthorisationController {

    private final UserRepository userRepository;

    public AuthorisationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/index")
    public String login(Model model, User user, HttpSession session) {
        model.addAttribute("user", user);
        User loggedUser = (User) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "index";
        }
        return "redirect:/menu";
    }


    @PostMapping
    public void processLoginAttempt(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @ModelAttribute("user") User user) throws IOException {
        Optional<User> maybeUser = Optional.ofNullable(userRepository.findUserByLastNameAndPassword(user.getLastName(), user.getPassword()));
        if (maybeUser.isPresent()) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedUser", maybeUser.get());

            session.setAttribute(String.format("listOfChosenMentors_%s", maybeUser.get().getUserId()), new ArrayList<User>());
            session.setAttribute(String.format("listOfChosenStudents_%s",maybeUser.get().getUserId()), new ArrayList<User>());

            if (maybeUser.get().getUserType() == 3) {
                response.sendRedirect(request.getContextPath() + "/admin_menu");
            } else if (maybeUser.get().getUserType() == 2) {
                response.sendRedirect(request.getContextPath() + "/mentor_menu");
            } else if (maybeUser.get().getUserType() == 1) {
                response.sendRedirect(request.getContextPath() + "/codecooler_menu");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index");
        }
    }

    @GetMapping("/logout")
    public String processLogout(HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/index";
    }
}
