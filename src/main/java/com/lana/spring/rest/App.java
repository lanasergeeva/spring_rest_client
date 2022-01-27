package com.lana.spring.rest;

import com.lana.spring.rest.configuration.MyConfig;
import com.lana.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
      /*  List<Employee> employees = communication.showAllEmployees();
        System.out.println(employees);*/
       /* Employee employee = communication.showEmployeeById(4);
        System.out.println(employee);
        Employee employeeNew = new Employee("Tim", "Cave", 444, "IT");
        employeeNew.setId(1);
        communication.addNewEmployee(employeeNew);*/
        communication.deleteEmployee(11);
    }
}
