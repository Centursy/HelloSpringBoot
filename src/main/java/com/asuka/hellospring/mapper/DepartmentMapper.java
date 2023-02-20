package com.asuka.hellospring.mapper;

import com.asuka.hellospring.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {
    List<Department> quaryDepartmentList();
}
