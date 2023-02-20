package com.asuka.hellospring.mapper;

import com.asuka.hellospring.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
    List<Employee> queryEmployeeList();
    Employee queryEmployeeById(int id);
    int add(Employee employee);
    int edit(Employee employee);
    int del(int id);
}
