package org.example.controller;

import org.example.entity.dto.EmployeeDTO;
import org.example.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("restController")
@RequestMapping("/api")
public class MainRestController {

    private final RepositoryService repositoryService;

    @Autowired
    public MainRestController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getEmployees(){
        List<EmployeeDTO> employeeDTOList = repositoryService.getAllEmployees();
        return employeeDTOList;
    }
}
