package org.example.deu_station.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mapcontroller {
    @GetMapping("/map")
    public String map() {
        return "map";
    }
}
