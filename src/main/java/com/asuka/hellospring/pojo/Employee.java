package com.asuka.hellospring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

//员工表
@Data
@NoArgsConstructor

public class Employee  {
    private Integer id;
    private String lastname;
    private String email;
    private int gender; //0:女   1:男

    private String department;
    private Date birth;
    //
    // public Employee(String lastName, String email, Integer gender,String department) {
    //     this.lastName = lastName;
    //     this.email = email;
    //     this.gender = gender;
    //     this.department = department;
    //     this.birth = new Date();
    // }



}



