package com.baizhi.service;

import com.baizhi.entity.Hospital;

import java.util.List;

public interface HospitalService {
    void insertHospital(Hospital hospital);

    void deleteHospital(Hospital hospital);

    void updateHospital(Hospital hospital);

    List<Hospital> selectHospitalsAll(Integer page, Integer rows);

    /*List<Hospital> selectHospitalsAll();*/
    Integer selectHospitalCount();

    List<Hospital> selectHospitalByDepartmentId(String id);

    List<Hospital> selectHospitalByGradeId(String id);
}
