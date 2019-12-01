package com.baizhi.dao;

import com.baizhi.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDAO {
    void insertDepartment(Department department);

    void deleteDepartment(Department department);

    void updateDepartment(Department department);

    List<Department> selectDepartmentsPage(@Param(value = "start") int start, @Param(value = "rows") int rows);

    Integer selectDepartmentCount();

    List<Department> selectDepartmentsAll();
    /*Department selectDepartmentById(Department department);*/
}
