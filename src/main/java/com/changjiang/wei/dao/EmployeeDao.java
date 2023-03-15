package com.changjiang.wei.dao;

import com.changjiang.wei.pojo.Department;
import com.changjiang.wei.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001,"Tom","aaaa@gamail.com",1,new Department(101, "Market")));
        employees.put(1002, new Employee(1002,"Jerry","bbbb@gamail.com",1,new Department(101, "Market")));
        employees.put(1003, new Employee(1003,"Kevin","cccc@gamail.com",0,new Department(101, "Market")));
        employees.put(1004, new Employee(1004,"Kate","dddd@gamail.com",1,new Department(101, "Market")));
        employees.put(1005, new Employee(1005,"Randell","eeee@gamail.com",0,new Department(101, "Market")));
    }

    private  static Integer initId = 1006;
    public void addEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);

    }

    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }
}
