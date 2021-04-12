package com.app.runcalc;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


import javax.validation.Valid;


import javax.servlet.http.HttpSession;


@Controller
public class RunCalcController {

//    @Autowired
//    public UserRepository userRepository;

//    @Autowired
//    public MeasurementRepository measurementRepository;
//
//    @Autowired
//    public WorkoutRepository workoutRepository;

    @Autowired
    public UserService userService;

    @Autowired
    public MeasurementService measurementService;

    @Autowired
    public WorkoutService workoutService;



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
        User logger = userService.getUser(user.getEmail());


        if (logger != null && logger.getEmail().equals(user.getEmail()) && logger.getPassword().equals(user.getPassword())) {
            s.setAttribute("currentUser", logger);
            return "redirect:/home";
        }

        String errorMsg = "Wrong email or password";
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

        userService.addUser(user);
        return "redirect:/home";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//    }


    @GetMapping("/home")
    public String getHome(@ModelAttribute Measurement measurement, HttpSession s, Model m) {
        User user = (User) s.getAttribute("currentUser");
        m.addAttribute("user", user);


        return "home";
    }


    @PostMapping("/home")
    public String postHome(@Valid Measurement measurement, @Valid User user, BindingResult result, HttpSession s) {
        if (result.hasErrors()) {
            return "home";
        }

//        User user = (User) s.getAttribute("currentUser");

        User currentUser = (User) s.getAttribute("currentUser");

        measurement.setUserId(currentUser.getId());
        measurement.setHeight(measurement.getHeight());
        measurement.setWeight(measurement.getWeight());
        measurement.setBmi(measurement.getBmi());
        measurement.setBmr(measurement.getBmr());
        measurement.setDateMeasurement(measurement.getDateMeasurement());
        measurementService.addMeasurement(measurement);


//        measurement.setId(user.getId());
//        measurement.setFirstName(user.getFirstName());
//        measurement.setLastName(user.getLastName());
//        measurement.setUserGender(user.getUserGender());
//        measurement.setBirthdate(user.getBirthdate());
//        measurement.setUserImg(user.getUserImg());
//        measurement.setBio(user.getBio());
//        measurement.setWantNewsletter(user.isWantNewsletter());
//        measurement.setEmail(user.getEmail());
//        measurement.setPassword(user.getPassword());

//        currentUser = userRepository.findById(currentUser.getId());
//        user = userService.getUser(user.getId()).get();


        s.setAttribute("currentUser", user);
        return "redirect:/home";
    }


    @GetMapping("/logout")
    public String getLogout(HttpSession s) {
        s.removeAttribute("currentUser");
        return "/logout";
    }


}


