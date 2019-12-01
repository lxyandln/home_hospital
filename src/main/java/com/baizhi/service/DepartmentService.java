package com.baizhi.service;

import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentService {
    void insertDepartment(Department department);

    void deleteDepartment(Department department);

    void updateDepartment(Department department);

    List<Department> selectDepartmentsPage(Integer page, Integer rows);

    Integer selectDepartmentCount();

    List<Department> selectDepartmentsAll();
}
