package com.baizhi.controller;

import com.baizhi.entity.Grade;
import com.baizhi.entity.Hospital;
import com.baizhi.service.GradeService;
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

@RequestMapping("/grade")
@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private HospitalService hospitalService;

    @ResponseBody
    @RequestMapping("/selectGradesAllController")
    public void selectGradesAllController(HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<select>");
        List<Grade> grades = gradeService.selectGradesAll();
        for (Grade grade : grades) {
            sb.append("<option value='" + grade.getId() + "'>" + grade.getGrade() + "<option>");
        }
        sb.append("</select>");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(sb.toString());
    }

    @RequestMapping("/selectGradesPageController")
    @ResponseBody
    public Map<String, Object> selectGradesPageController(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count = gradeService.selectGradeCount();
        long total = (count - 1) / rows + 1;
        List<Grade> grades = gradeService.selectGradesPage(page, rows);
        map.put("rows", grades);
        map.put("page", page);
        map.put("records", count);
        map.put("total", total);
        return map;
    }

    @ResponseBody
    @RequestMapping("edit")
    public void edit(Grade grade, String oper) {
        if (oper.equals("add")) {
            gradeService.insertGrade(grade);
        } else if (oper.equals("edit")) {
            gradeService.updateGrade(grade);
        } else if (oper.equals("del")) {
            List<Hospital> hospitals = hospitalService.selectHospitalByGradeId(grade.getId());
            if (hospitals.size() <= 0) {
                gradeService.deleteGrade(grade);
            }
        }
    }
}
