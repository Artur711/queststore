package com.queststore.controller;

import com.queststore.dao.UserLoginDAO;
import com.queststore.model.User;
import com.queststore.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@Controller
@SessionAttributes("loggedUser")
public class AuthorisationController {

    private final UserRepository userRepository;

    public AuthorisationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/index")
    public String login(Model model, User user) {
        model.addAttribute("user", user);
        return "index";
    }


    @PostMapping
    public void processLoginAttempt(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @ModelAttribute("user") User user) throws IOException {
        Optional<User> maybeUser = Optional.ofNullable(userRepository.findUserByLastNameAndPassword(user.getLastName(), user.getPassword()));
        if (maybeUser.isPresent()) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedUser", maybeUser.get());

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
        public void processLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }

            response.sendRedirect(request.getContextPath() + "/index");
    }
//
//    @PostMapping
//    public String postLogin(Model model, @ModelAttribute("user") User user) {
//        User loggedUser = userLoginDAO.getUser(user.getLastName(), user.getPassword());
//
//        if (loggedUser != null) {
//            model.addAttribute("loggedUser", loggedUser);
//
//            if (loggedUser.getUserType() == 3) {
//                return "redirect:/admin_menu";
//            } else if (loggedUser.getUserType() == 2) {
//                return "redirect:/mentor_menu";
//            } else if (loggedUser.getUserType() == 1) {
//                return "redirect:/codecooler_menu";
//            }
//        }
//        return "index";
//    }
}
