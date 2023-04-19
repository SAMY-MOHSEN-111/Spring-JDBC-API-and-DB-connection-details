package com.global.hr.jdbchrproject.config;

import com.global.hr.jdbchrproject.repository.EmployeeNamedParameterJDBCTemplateImpl;
import org.springframework.context.annotation.*;

@Configuration
public class BeanConfig {
    @Bean
    @Lazy
    @Primary
    @Scope("singleton")
    public EmployeeNamedParameterJDBCTemplateImpl getEmployeeNamedParameterJDBCTemplate(){
        System.out.println("done");
        return new EmployeeNamedParameterJDBCTemplateImpl();
    }
}
