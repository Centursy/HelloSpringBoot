package com.asuka.hellospring.controller;


// import com.asuka.hellospring.dao.DepartmentDao;
// import com.asuka.hellospring.dao.EmployeeDao;

import com.asuka.hellospring.mapper.DepartmentMapper;
import com.asuka.hellospring.mapper.EmployeeMapper;
import com.asuka.hellospring.pojo.Department;
import com.asuka.hellospring.pojo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    //查询
    @RequestMapping("/emps")
    public String list(Model model){
        List<Employee> employees = employeeMapper.queryEmployeeList();
        model.addAttribute("emps",employees);
        return "emp/list.html";
    }

 //返回添加页面，返回部门信息
     @GetMapping("/emp")
     public String add (Model model){
         //查出所有部门的信息
         List<Department> departments = departmentMapper.quaryDepartmentList();
         model.addAttribute("departments",departments);
         return "emp/add";
     }

 //接收添加员工请求
     @PostMapping("/emp")
     public String save (Employee employee){
         //添加的操作
         System.out.println("save-->"+employee);
         employeeMapper.add(employee); //调用底层业务保存员工信息
         return "redirect:/emps";
     }

        //修改时填的默认值
        @GetMapping("/emp/{id}")
        public String edit(@PathVariable("id")Integer id,Model model){
            //先查出原来的数据
            Employee employee = employeeMapper.queryEmployeeById(id);
            model.addAttribute("emp",employee);
            //查出所有部门的信息
            List<Department> departments = departmentMapper.quaryDepartmentList();
            model.addAttribute("departments",departments);
            return "emp/edit";
        }
        //保存编辑
        @PostMapping("/editemp")
        public String editemp(Employee employee){
            employeeMapper.edit(employee);
            return "redirect:/emps";
        }

        //删除
         @GetMapping("/empdel/{id}")
         public String del(@PathVariable("id")Integer id){
             employeeMapper.del(id);
             return "redirect:/emps";
         }

    // //查询
    // @GetMapping("/sql")
    // public List<Employee> queryEvaList() {
    //     List<Employee> employees = employeeMapper.queryEmployeeList();
    //      for (Employee employee : employees) {
    //          System.out.println(employee);
    //      }
    //     return employees;
    // }

    // @Autowired
    // EmployeeDao employeeDao;
    // @Autowired
    // DepartmentDao departmentDao;

    // @RequestMapping("/emps")
    // public String list(Model model){
    //     Collection<Employee> employees = employeeDao.getAll();
    //     model.addAttribute("emps",employees);
    //     return "emp/list.html";
    // }
 //
 //
 //
 // //返回添加页面，返回部门信息
 //     @GetMapping("/emp")
 //     public String add (Model model){
 //         //查出所有部门的信息
 //         Collection<Department> departments = departmentDao.getDepartments();
 //         model.addAttribute("departments",departments);
 //         return "emp/add";
 //     }
 // //接收添加员工请求
 //     @PostMapping("/emp")
 //     public String save (Employee employee){
 //         //添加的操作
 //         System.out.println("save-->"+employee);
 //         employeeDao.save(employee); //调用底层业务保存员工信息
 //         return "redirect:/emps";
 //     }
 //     //修改时填的默认值
 //     @GetMapping("/emp/{id}")
 //     public String edit(@PathVariable("id")Integer id,Model model){
 //         //先查出原来的数据
 //         Employee employee = employeeDao.getEmployeeByID(id);
 //         model.addAttribute("emp",employee);
 //         //查出所有部门的信息
 //         Collection<Department> departments = departmentDao.getDepartments();
 //         model.addAttribute("departments",departments);
 //         return "emp/edit";
 //     }
 //     //保存编辑
 //     @PostMapping("/editemp")
 //     public String editemp(Employee employee){
 //         employeeDao.save(employee);
 //         return "redirect:/emps";
 //     }
 //     //删除
 //      @GetMapping("/empdel/{id}")
 //      public String del(@PathVariable("id")Integer id){
 //          employeeDao.delete(id);
 //          return "redirect:/emps";
 //      }
 }
