package com.restdemo.restdemo.dao;

import com.restdemo.restdemo.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery("FROM Employee", Employee.class);
        return employeeTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public void findEmployeeByIdAndUpdate(int id, Employee employee) {
        Employee employ = findEmployeeById(id);
        employ.setDateJoined(employee.getDateJoined());
        employ.setFirstName(employee.getFirstName());
        employ.setEmail(employee.getEmail());
        employ.setMi(employee.getMi());
        employ.setLastName(employee.getLastName());
        entityManager.merge(employ);
    }

    @Override
    @Transactional
    public void findEmployeeByIdAndDelete(int id) {
        entityManager.remove(findEmployeeById(id));
    }
}
