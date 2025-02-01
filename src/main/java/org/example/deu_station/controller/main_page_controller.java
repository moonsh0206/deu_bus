package org.example.deu_station.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class main_page_controller {
    @GetMapping("/")
    public String deu_bus() {
        return "deu_bus";
    }
}
