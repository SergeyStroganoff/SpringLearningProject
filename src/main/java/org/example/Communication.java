package org.example;

import org.example.entities.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component("communication")
public class Communication {

    private static final String URL = "http://127.0.0.1:8080/SpringlearningProject/api";
    @Autowired
    private RestTemplate restTemplate;

    public List<EmployeeDTO> getAllEmployees() {
        ResponseEntity<List<EmployeeDTO>> responseEntity = restTemplate.exchange(URL + "/employees", HttpMethod.GET, null, new ParameterizedTypeReference<List<EmployeeDTO>>() {
        });
        List<EmployeeDTO> employeeDTOList = responseEntity.getBody();
        return employeeDTOList;
    }

    public EmployeeDTO getEmployeeDTO(long id) {
        EmployeeDTO employeeDTO = restTemplate.getForObject(URL + "/employees/" + id, EmployeeDTO.class);
        return employeeDTO;
    }

    public void saveOrUpdateEmployees(EmployeeDTO employeeDTO) {
        if (employeeDTO.getId() == 0) {
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL + "/employees/save", employeeDTO, String.class);
            System.out.println("New employee was added" + responseEntity.getBody());
        } else {
            restTemplate.put(URL + "/employees/save", EmployeeDTO.class);
        }
    }
}
