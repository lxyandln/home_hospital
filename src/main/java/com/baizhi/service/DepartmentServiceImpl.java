package com.baizhi.service;

import com.baizhi.dao.DepartmentDAO;
import com.baizhi.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public void insertDepartment(Department department) {
        String id = UUID.randomUUID().toString();
        department.setId(id);
        departmentDAO.insertDepartment(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        departmentDAO.deleteDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDAO.updateDepartment(department);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Department> selectDepartmentsPage(Integer page, Integer rows) {
        int start = (page - 1) * rows;
        List<Department> list = departmentDAO.selectDepartmentsPage(start, rows);
        return list;
    }

    @Override
    public Integer selectDepartmentCount() {
        Integer count = departmentDAO.selectDepartmentCount();
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Department> selectDepartmentsAll() {
        List<Department> list = departmentDAO.selectDepartmentsAll();
        return list;
    }
}
