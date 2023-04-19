package com.global.hr.jdbchrproject.repository;

import com.global.hr.jdbchrproject.mapper.EmployeeMapper;
import com.global.hr.jdbchrproject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// DAO Implementation
//@Component
//@Repository
//@Primary
public class EmployeeNamedParameterJDBCTemplateImpl implements EmployeeRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void wireNamedParameterJDBCTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int count() {
        Integer obj = namedParameterJdbcTemplate.queryForObject("select count(*) from employee", new HashMap<>(), Integer.class);
        if (obj != null)
            return obj;
        return 0;
    }

    @Override
    public Employee findById(long id) {
        return namedParameterJdbcTemplate.queryForObject("select id, name, salary from employee where id = :id",
                new HashMap<>(Map.of("id", id)),
                new EmployeeMapper());
    }

    @Override
    public List<Employee> findAll() {
        return namedParameterJdbcTemplate.query("select id, name, salary from employee",
                new HashMap<>(),
                new EmployeeMapper());
    }

    @Override
    public List<Employee> findByNameAndSalary(String name, double salary) {
        return namedParameterJdbcTemplate.query("select * from employee where name = :name and salary = :salary",
                new HashMap<>(Map.of("name", name, "salary", salary)),
                new EmployeeMapper()
        );
    }

    @Override
    public int insert(Employee employee) {
        return namedParameterJdbcTemplate.update("insert into employee (id,name,salary) values (:id,:name,:salary)",
                new HashMap<>(Map.of(
                        "id", employee.getId(),
                        "name", employee.getName(),
                        "salary", employee.getSalary()
                )));
    }

    @Override
    public int update(Employee employee) {
        return namedParameterJdbcTemplate.update("update employee set name = :name, salary = :salary where id = :id",
                new HashMap<>(Map.of(
                        "id", employee.getId(),
                        "name", employee.getName(),
                        "salary", employee.getSalary()
                )));
    }

    @Override
    public int delete(long id) {
        return namedParameterJdbcTemplate.update("delete from employee where id = :id",
                new HashMap<>(Map.of("id", id)));
    }
}
