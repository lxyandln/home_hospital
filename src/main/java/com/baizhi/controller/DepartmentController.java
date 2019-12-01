package com.baizhi.controller;

import com.baizhi.entity.Department;
import com.baizhi.entity.Hospital;
import com.baizhi.service.DepartmentService;
import com.baizhi.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/department")
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private HospitalService hospitalService;

    @RequestMapping("/selectDepartmentsPageController")
    @ResponseBody
    public Map<String, Object> selectDepartmentsPageController(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count = departmentService.selectDepartmentCount();
        long total = (count - 1) / rows + 1;
        List<Department> departments = departmentService.selectDepartmentsPage(page, rows);
        map.put("rows", departments);
        map.put("page", page);
        map.put("records", count);
        map.put("total", total);
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectDepartmentsAllController")
    public void selectDepartmentsAllController(HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<select>");
        List<Department> departments = departmentService.selectDepartmentsAll();
        for (Department department : departments) {
            sb.append("<option value='" + department.getId() + "'>" + department.getDepart() + "<option>");
        }
        sb.append("</select>");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(sb.toString());
    }

    @ResponseBody
    @RequestMapping("edit")
    public void edit(Department department, String oper) {
        if (oper.equals("add")) {
            departmentService.insertDepartment(department);
        } else if (oper.equals("edit")) {
            departmentService.updateDepartment(department);
        } else if (oper.equals("del")) {
            List<Hospital> hospitals = hospitalService.selectHospitalByDepartmentId(department.getId());
            if (hospitals.size() <= 0) {
                departmentService.deleteDepartment(department);
            }
        }
    }
}
