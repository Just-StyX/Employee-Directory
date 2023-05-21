package com.restdemo.restdemo.dao;

import com.restdemo.restdemo.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee employee);
    Employee findEmployeeById(int id);
    List<Employee> getAllEmployee();
    void findEmployeeByIdAndUpdate(int id, Employee employee);
    void findEmployeeByIdAndDelete(int id);
}
