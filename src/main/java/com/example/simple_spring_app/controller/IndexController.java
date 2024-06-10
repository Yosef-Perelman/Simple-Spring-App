package com.example.simple_spring_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @GetMapping("/add")
    public String add_job() {
        return "add";
    }

//    @PostMapping("/greeting")
//    public String greetingSubmit(@ModelAttribute Job greeting, Model model) {
//        model.addAttribute("greeting", greeting);
//        return "result";
//    }

}
