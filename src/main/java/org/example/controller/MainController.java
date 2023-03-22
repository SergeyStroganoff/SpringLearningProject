package org.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.entity.dto.DepartmentDTO;
import org.example.entity.dto.EmployeeDTO;
import org.example.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("mainController")
public class MainController {

    private final RepositoryService repositoryService;
    private static final Log logger = LogFactory.getLog(MainController.class);

    @Autowired
    public MainController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)     // new method
    public String showEntryPage(Model model) {
        List<EmployeeDTO> allEmployeesList = repositoryService.getAllEmployees();
        model.addAttribute("allEmployee", allEmployeesList);
        logger.info("allEmployee list successfully returned");
        return "index";
    }

    @RequestMapping(value = "/addNewEmployee")                   //new method
    public String addNewEmployee(Model model) {
        model.addAttribute("newEmployeeDTO", new EmployeeDTO());
        List<DepartmentDTO> departmentDTOList = repositoryService.getAllDepartments();
        Map<String, String> departmentsDTO = new HashMap<>();
        departmentDTOList.forEach(x -> departmentsDTO.put(x.getDepartmentName(), x.getDepartmentName()));
        model.addAttribute("departmentsDTO", departmentsDTO);
        return "addNewEmployeeForm";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("newEmployee") EmployeeDTO newEmployee,
                               BindingResult bindingResult, Model model) { // BindingResult goes after @ModelAttribute !!!
        if (bindingResult.hasErrors()) { // validation
            return "addNewEmployeeForm";
        }
        repositoryService.saveOrUpdate(newEmployee);
        model.addAttribute("operationResult", "successfully added" + newEmployee.getName()); // another way validation
        model.addAttribute("newEmployee", newEmployee);
        return "deatailResult";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empid") long id, Model model) { // BindingResult goes after @ModelAttribute !!!
        repositoryService.deleteEmployee(id);
        List<EmployeeDTO> allEmployeesList = repositoryService.getAllEmployees();
        model.addAttribute("allEmployee", allEmployeesList);
        return "index";
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
