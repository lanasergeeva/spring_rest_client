package com.lana.spring.rest;

import com.lana.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/spring/api/employees/";

    public List<Employee> showAllEmployees() {
        ResponseEntity<List<Employee>> exchange = restTemplate.exchange(URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Employee>>() {
                });
        List<Employee> body = exchange.getBody();
        return body;
    }


    public Employee showEmployeeById(int id) {
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

    public void addNewEmployee(Employee employee) {
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> stringResponseEntity =
                    restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New Employee was added to database");
            System.out.println(stringResponseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with id " + id + " was added");
        }
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with id " + id + " was deleted ");
    }
}
