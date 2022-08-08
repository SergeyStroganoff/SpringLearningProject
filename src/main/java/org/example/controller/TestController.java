package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller("mainController")
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showEntryPage() {
        return "index";
    }

    @RequestMapping(value = "/askName", method = RequestMethod.GET)
    public String showAskPage() {
        return "askPage";
    }

    @RequestMapping(value = "/showAnswer", method = RequestMethod.GET)
    public String showAnswerPage(HttpServletRequest request, Model model) {
        String empName = request.getParameter("askForm");
        empName += " Mister";
        model.addAttribute("changedAttributeAskForm", empName);
        return "answer";
    }

    @RequestMapping(value = "/showAnswerAnotherWay", method = RequestMethod.GET)
    public String showAnswerPageAnotherWay(@RequestParam("askForm") String parameter, Model model) {
        String empName = "Mister" + parameter;
        model.addAttribute("changedAttributeAskForm", empName);
        return "answer";
    }
}
