 // package com.asuka.hellospring.dao;
 //
 // import com.asuka.hellospring.pojo.Department;
 // import com.asuka.hellospring.pojo.Employee;
 // import org.springframework.beans.factory.annotation.Autowired;
 // import org.springframework.stereotype.Repository;
 //
 // import java.util.Collection;
 // import java.util.HashMap;
 // import java.util.Map;
 // @Repository
 // public class EmployeeDao {
 //     private static Map<Integer, Employee> employees = null;
 //     //员工所属的部门
 //     @Autowired
 //     private DepartmentDao departmentDao;
 //
 //     static {
 //         employees = new HashMap<Integer, Employee>();    //创建了一个部门表
 //
 //         employees.put(1001, new Employee(1001, "AA", "12w3@123.com", 1, new Department(101, "教学部")));
 //         employees.put(1002, new Employee(1002, "Bb", "12c3@123.com", 0, new Department(102, "市场部")));
 //         employees.put(1003, new Employee(1003, "CC", "12v3@123.com", 1, new Department(103, "科研部")));
 //         employees.put(1004, new Employee(1004, "DD", "12u3@123.com", 0, new Department(104, "eva保养部门")));
 //     }
 //     //自增主键！
 //     private static Integer initId = 1005;
 //     //增加一个员工
 //     public  void save(Employee employee){
 //         if (employee.getId()==null){
 //             employee.setId(initId++);
 //         }
 //
 //         employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
 //         employees.put(employee.getId(),employee);
 //     }
 //     //查询全部员工信息
 //     public Collection<Employee> getAll(){
 //         return employees.values();
 //     }
 //     //查询通过id查询
 //     public Employee getEmployeeByID(Integer id){
 //         return employees.get(id);
 //     }
 //     //删除员工
 //     public void delete(Integer id){
 //         employees.remove(id);
 //     }
 // }