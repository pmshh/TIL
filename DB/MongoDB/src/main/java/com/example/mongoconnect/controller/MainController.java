package com.example.mongoconnect.controller;

import com.example.mongoconnect.repository.Table1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final Table1Repository table1Repository;

    @GetMapping("/")
    public String mainP(Model model) {

        model.addAttribute("DATA", table1Repository.findAll());

        return "index";
    }
}
