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

    @Autowired
    public InfoRepository infoRepository;

    @Autowired
    public CalculationsRepository calculationsRepository;

/*    public RunCalcController(UserRepository userRepository, InfoRepository infoRepository, CalculationsRepository calculationsRepository) {
        this.userRepository = userRepository;
        this.infoRepository = infoRepository;
        this.calculationsRepository = calculationsRepository;
    }*/


    @GetMapping("/")
    public String Intro() {
        return "intro";
    }

    @GetMapping("/about")
    public String About() {
        return "about";
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
        userRepository.save(user);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHome(@ModelAttribute Info info, HttpSession s, Model m) {
        User user = (User) s.getAttribute("currentUser");
//        Calculations calculations = (Calculations) s.getAttribute("currentCalculations");
        m.addAttribute("user", user);
//        m.addAttribute("user", calculations);


        return "home";
    }


    @PostMapping("/home")
    public String postHome(@Valid User user, @Valid Info info, @Valid Calculations calculations, BindingResult result, HttpSession s, Model m) {
        if (result.hasErrors()) {
            return "home";
        }
        User currentUser = (User) s.getAttribute("currentUser");


        // Info
        info.setAge(info.getAge());
        info.setUserGender(info.getUserGender());
        info.setHeight(info.getHeight());
        info.setWeight(info.getWeight());
        info.setExerciseLevel(info.getExerciseLevel());

        info.setId(currentUser.getId());

        infoRepository.save(info);

        // Calculations
        calculations.setId(currentUser.getId());
        calculations.setBmi(calculations.getBmi());
        calculations.setBmr(calculations.getBmr());

        calculationsRepository.save(calculations);


        
        return "redirect:/home";
    }


    @GetMapping("/logout")
    public String getLogout(HttpSession s) {
        s.removeAttribute("currentUser");
        return "redirect:/logout";
    }


}


