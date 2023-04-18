package com.global.hr.jdbchrproject.repository;

import com.global.hr.jdbchrproject.model.Employee;

import java.util.List;

// this is our DAO
public interface EmployeeRepository {
    int count();
    Employee findById(long id);
    List<Employee> findAll();
    List<Employee> findByNameAndSalary(String name, double salary);
    int insert(Employee employee);
    int update(Employee employee);
    int delete(long id);
}
