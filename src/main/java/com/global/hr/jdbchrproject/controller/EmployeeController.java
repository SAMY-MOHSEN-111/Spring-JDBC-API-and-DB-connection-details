package com.global.hr.jdbchrproject.controller;

import com.global.hr.jdbchrproject.model.Employee;
import com.global.hr.jdbchrproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "employees")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    @Autowired
    public void wireEmployeeRepository(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    @GetMapping("/count")
    public int count(){
        return employeeRepository.count();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") long id){
        return employeeRepository.findById(id);
    }

    @GetMapping("/")
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/find")
    public List<Employee> findByNameAndSalary(
            @RequestParam String name,
            @RequestParam double salary
    ){
        return employeeRepository.findByNameAndSalary(name,salary);
    }

    @PostMapping("/add")
    public int insert(@RequestBody Employee employee){
        return employeeRepository.insert(employee);
    }

    @PutMapping("/update")
    public int update(@RequestBody Employee employee){
        return employeeRepository.update(employee);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") long id){
        return employeeRepository.delete(id);
    }
}
