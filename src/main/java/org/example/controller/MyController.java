package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("mainController")
public class MyController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showEntryPage() {
        return "index";
    }
}
