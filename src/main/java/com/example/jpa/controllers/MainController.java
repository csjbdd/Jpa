package com.example.jpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @GetMapping("/main/{name}")
    public String test(Model model, @PathVariable("name") String name) {
        model.addAttribute("name", name);
        return "main";
    }
}
