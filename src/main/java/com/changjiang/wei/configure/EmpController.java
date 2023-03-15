package com.changjiang.wei.configure;

import com.changjiang.wei.dao.DepartmentDao;
import com.changjiang.wei.dao.EmployeeDao;
import com.changjiang.wei.pojo.Department;
import com.changjiang.wei.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String getAllEmp(Model model) {
        Collection<Employee> employees = employeeDao.getAllEmployees();
        model.addAttribute("emps",employees);
        return "list";
    }

    @GetMapping ("/emp")
    public String addEmp(Model model) {
        // 获取出所有的部门信息， 方便前台显示
        // get all the info of departments
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "add";
    }

    @PostMapping ("/emp")
    public String saveEmp(Employee employee) {
        System.out.println("aaaaaaaaaaaaaa");
        employeeDao.addEmployee(employee);
        // 跳转另一个接口
        return "redirect:/emps";
    }

    @RequestMapping("/emp/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Model model) {

        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "update";
    }

    @PostMapping ("/update")
    public String updateEmpImpl(Employee employee) {
       return saveEmp(employee);
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
         employeeDao.delete(id);
        return "redirect:/emps";
    }

  /*  @GetMapping("/test")
    public String jdbc_sql(@RequestParam("id") String id){
        String sql = "select * from tb_user where id =" + id;
        System.out.println(sql);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return "result:"+maps;
    }*/

}
