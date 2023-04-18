package com.global.hr.jdbchrproject.config;

import com.global.hr.jdbchrproject.model.Employee;
import com.global.hr.jdbchrproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class StartupProject implements ApplicationRunner {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private EmployeeRepository employeeRepository;

    @Autowired// setter injection
    public void wireJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Autowired// setter injection ==> remember that setter overrides constructor
    public void wireEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        jdbcTemplate.execute("drop table  if exists employee");
        jdbcTemplate.execute("create table employee(id serial, name varchar(255), salary numeric(15,2)) ");

        if (employeeRepository.count() == 0) {
            employeeRepository.insert(new Employee(1L, "samy", 5000));
            employeeRepository.insert(new Employee(2L, "ahmed", 6000));
            employeeRepository.insert(new Employee(3L, "mohamed", 7000));
            employeeRepository.insert(new Employee(4L, "youssef", 8000));
            employeeRepository.insert(new Employee(5L, "tarek", 9000));
        }

    }
}
