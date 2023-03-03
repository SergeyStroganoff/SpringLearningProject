package org.example.controller;

import org.example.entity.dto.EmployeeDTO;
import org.example.exceptions.NoSuchEmployeeException;
import org.example.exeption_handling.ExceptionMessage;
import org.example.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<EmployeeDTO> getEmployees() {
        List<EmployeeDTO> employeeDTOList = repositoryService.getAllEmployees();
        return employeeDTOList;
    }

    @GetMapping("/employees/{id}")
    public EmployeeDTO getEmployees(@PathVariable int id) throws NoSuchEmployeeException {
        EmployeeDTO employeeDTO = repositoryService.getEmployeeDTO(id);
        return employeeDTO;
    }


    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> exceptionMessageResponseEntity(NoSuchEmployeeException noSuchEmployeeException) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setInfo(noSuchEmployeeException.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> exceptionMessageResponseEntity(Exception exception) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setInfo(exception.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
    }
}
