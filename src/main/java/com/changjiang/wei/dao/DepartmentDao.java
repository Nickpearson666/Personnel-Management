package com.changjiang.wei.dao;

import com.changjiang.wei.pojo.Department;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();
        departments.put(101, new Department(101, "Market"));
        departments.put(102, new Department(102,"Education"));
        departments.put(103, new Department(103,"Public"));
        departments.put(104, new Department(104,"IT"));
        departments.put(105, new Department(105,"Play"));
    }

    public Collection<Department> getDepartments() {
        return departments.values();
    }

    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
