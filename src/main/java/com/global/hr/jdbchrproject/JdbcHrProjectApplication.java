package com.global.hr.jdbchrproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcHrProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(JdbcHrProjectApplication.class, args);
    }

    /*

    jdbctemplate.queryForObject("sql",Object[]{},Object.class);
    jdbctemplate.query("sql",Object[]{},Mapper);
    jdbctemplate.update("sql",Object[]{}); ==> insert, update, delete
    jdbctemplate.execute("sql");

    ------------------------------------------

    namedParameterJdbctemplate.queryForObject("sql",HashMap<>(),Object.class);
    namedParameterJdbctemplate.query("sql",HashMap<>(),Mapper);
    namedParameterJdbctemplate.update("sql",HashMap<>()); ==> insert, update, delete
    namedParameterJdbctemplate.execute("sql");

     */

    /*
    spring jdbc api: is low level and much faster and provides more flexibility
    spring data jdbc: is high level, slower than spring jdbc api but provides more features
    spring data jpa: is high level, slower than spring data jdbc but provides more features
     */
}
