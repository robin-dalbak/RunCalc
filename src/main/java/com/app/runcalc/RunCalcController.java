package com.app.runcalc;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


import javax.validation.Valid;


import javax.servlet.http.HttpSession;


@Controller
public class RunCalcController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public InfoRepository infoRepository;

    @Autowired
    public CalculationsRepository calculationsRepository;



    @GetMapping("/")
    public String Intro() {
        return "intro";
    }

    @GetMapping("/about")
    public String About(@ModelAttribute User user) {

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
        m.addAttribute("user", user);


        return "home";
    }


    @PostMapping("/home")
    public String postHome(@Valid Info info, @Valid Calculations calculations, BindingResult result, HttpSession s) {
        if (result.hasErrors()) {
            return "home";
        }

        User currentUser = (User) s.getAttribute("currentUser");

        info.setFirstName(currentUser.getFirstName());
        info.setLastName(currentUser.getLastName());
        info.setPassword(currentUser.getPassword());
        info.setEmail(currentUser.getEmail());
        infoRepository.save(info);


//         Calculations
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


