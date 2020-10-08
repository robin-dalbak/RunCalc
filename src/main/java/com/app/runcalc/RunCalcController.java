package com.app.runcalc;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RunCalcController {

    @Autowired
    public UserRepository userRepository;

    public RunCalcController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @GetMapping("/")
    public String Intro() {
        return "intro";
    }

    @GetMapping("/login")
    public String getLogin(@ModelAttribute User user) {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute User user, HttpSession s, Model m) {
        User logger = userRepository.findByEmail(user.getEmail());


        if (logger != null && logger.getEmail().equals(user.getEmail()) && logger.getPassword().equals(user.getPassword())) {
            s.setAttribute("currentUser", logger);
            return "redirect:/home";
        }

        String errorMsg = "Wrong email or wrong password";
        m.addAttribute("errorMsg", errorMsg);
        return "login";
    }


    @GetMapping("/register")
    public String getRegister(@ModelAttribute User user) {
        return "newuser";
    }

    @PostMapping("/register")
    public String postRegister(@Valid User user, BindingResult result, HttpSession s) {
        if (result.hasErrors()) {
            return "newuser";
        }
        s.setAttribute("currentUser", user);
        s.setAttribute("userId", user.getId());
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHome(@ModelAttribute User user) {
        return "home";
    }

    @GetMapping("/logout")
    public String getLogout(@ModelAttribute User user) {
        return "logout";
    }


}

