package com.global.hr.jdbchrproject.repository;

import com.global.hr.jdbchrproject.mapper.EmployeeMapper;
import com.global.hr.jdbchrproject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

// DAO Implementation
@Component
public class EmployeeJDBCTemplateImpl implements EmployeeRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void wireJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
    }

    @Override
    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("select id, name, salary from employee where id = ?",
                new Object[]{id},
                new EmployeeMapper());
        // suppose it has 5 attributes, and you want just 3, then mapper comes to rescue
    }


    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee",new EmployeeMapper());
    }

    @Override
    public List<Employee> findByNameAndSalary(String name, double salary) {
        return jdbcTemplate.query("select id,name, salary from employee where name=? and salary=?",
                new Object[]{name,salary},
                new EmployeeMapper());
    }

    @Override
    public int insert(Employee employee) {
        return jdbcTemplate.update("insert into employee (id, name, salary) values (?,?,?)",
                new Object[]{employee.getId(),employee.getName(),employee.getSalary()});
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("update employee set name = ?, salary = ?",
                new Object[]{employee.getName(), employee.getSalary()});
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("delete from employee where id = ?",
                new Object[]{id});
    }
}
