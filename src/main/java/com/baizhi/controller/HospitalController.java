package com.baizhi.controller;

import com.baizhi.entity.Hospital;
import com.baizhi.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/hospital")
@Controller
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @RequestMapping("/selectHospitalsAllController")
    @ResponseBody
    public Map<String, Object> selectHospitalsAllController(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer count = hospitalService.selectHospitalCount();
        long total = (count - 1) / rows + 1;
        List<Hospital> hospitals = hospitalService.selectHospitalsAll(page, rows);
        map.put("rows", hospitals);
        map.put("page", page);
        map.put("records", count);
        map.put("total", total);
        return map;
    }

    @ResponseBody
    @RequestMapping("edit")
    public void edit(Hospital hospital, String oper) {
        if (oper.equals("add")) {
            hospitalService.insertHospital(hospital);
        } else if (oper.equals("edit")) {
            hospitalService.updateHospital(hospital);
        } else if (oper.equals("del")) {
            hospitalService.deleteHospital(hospital);
        }
    }

}
