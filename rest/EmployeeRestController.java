package com.restdemo.restdemo.rest;

import com.restdemo.restdemo.dao.EmployeeDAO;
import com.restdemo.restdemo.entities.Employee;
import com.restdemo.restdemo.errors.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeDAO.save(employee);
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        if(employeeId >= employeeDAO.getAllEmployee().size() || employeeId < 1) {
            throw new EmployeeNotFoundException("Employee Id Not Found - " + employeeId);
        }

        return employeeDAO.findEmployeeById(employeeId);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployee();
    }

    @PutMapping("/employee/{employeeId}")
    public void findEmployeeByIdAndUpdate(@PathVariable int employeeId, @RequestBody Employee employee) {
        if(employeeId >= employeeDAO.getAllEmployee().size() || employeeId < 1) {
            throw new EmployeeNotFoundException("Employee Id Not Found - " + employeeId);
        }
        employeeDAO.findEmployeeByIdAndUpdate(employeeId, employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public void findEmployeeByIdAndDelete(@PathVariable int employeeId) {
        if(employeeId >= employeeDAO.getAllEmployee().size() || employeeId < 1) {
            throw new EmployeeNotFoundException("Employee Id Not Found - " + employeeId);
        }
        employeeDAO.findEmployeeByIdAndDelete(employeeId);
    }
}
