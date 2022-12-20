package org.example.controller;

import org.example.entity.dto.DepartmentDTO;
import org.example.entity.dto.EmployeeDTO;
import org.example.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("mainController")
public class MainController {

    RepositoryService repositoryService;

    @Autowired
    public MainController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)     // new method
    public String showEntryPage(Model model) {
        List<EmployeeDTO> allEmployeesDAO = repositoryService.getAllEmployees();
        model.addAttribute("allEmployee", allEmployeesDAO);
        return "index";
    }

    @RequestMapping(value = "/addNewEmployee")                   //new method
    public String addNewEmployee(Model model) {
        model.addAttribute("newEmployee", new EmployeeDTO());
        List<DepartmentDTO> departmentDTOS = repositoryService.getAllDepartments();
        Map<String, String> departments = new HashMap<>();
        departmentDTOS.forEach(x -> departments.put(x.getDepartmentName(), x.getDepartmentName()));
        model.addAttribute("departments", departments);
        return "addNewEmployeeForm";
    }

    @RequestMapping(value = "/saveEmployee")                   //new method
    public String saveNewEmployee(@RequestParam("askForm") String parameter) {
        return "addNewEmployeeForm";
    }


    @RequestMapping(value = "/askName", method = RequestMethod.GET)
    public String showAskPage() {
        return "askPage";
    }

    @RequestMapping(value = "/showAnswer", method = RequestMethod.GET)
    public String showAnswerPage(HttpServletRequest request, Model model, HttpServletResponse response) {
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
