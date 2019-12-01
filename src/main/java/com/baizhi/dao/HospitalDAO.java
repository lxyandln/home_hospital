package com.baizhi.dao;

import com.baizhi.entity.Hospital;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HospitalDAO {
    void insertHospital(Hospital hospital);

    void deleteHospital(Hospital hospital);

    void updateHospital(Hospital hospital);

    /*List<Hospital> selectHospitalsAll();*/
    List<Hospital> selectHospitalsAll(@Param(value = "start") int start, @Param(value = "rows") int rows);

    Integer selectHospitalCount();

    List<Hospital> selectHospitalByDepartmentId(String id);

    List<Hospital> selectHospitalByGradeId(String id);
}
