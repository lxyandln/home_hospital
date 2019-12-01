package com.baizhi.service;

import com.baizhi.dao.HospitalDAO;
import com.baizhi.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalDAO hospitalDAO;

    @Override
    public void insertHospital(Hospital hospital) {
        String id = UUID.randomUUID().toString();
        hospital.setId(id);
        hospitalDAO.insertHospital(hospital);
    }

    @Override
    public void deleteHospital(Hospital hospital) {
        hospitalDAO.deleteHospital(hospital);
    }

    @Override
    public void updateHospital(Hospital hospital) {
        hospitalDAO.updateHospital(hospital);
    }

    /* @Override
     @Transactional(propagation = Propagation.SUPPORTS)
     public List<Hospital> selectHospitalsAll() {
         List<Hospital> list = hospitalDAO.selectHospitalsAll();
         return list;
     }*/
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Hospital> selectHospitalsAll(Integer page, Integer rows) {
        int start = (page - 1) * rows;
        List<Hospital> list = hospitalDAO.selectHospitalsAll(start, rows);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer selectHospitalCount() {
        Integer count = hospitalDAO.selectHospitalCount();
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Hospital> selectHospitalByDepartmentId(String id) {
        List<Hospital> list = hospitalDAO.selectHospitalByDepartmentId(id);
        return list;
    }

    @Override
    public List<Hospital> selectHospitalByGradeId(String id) {
        List<Hospital> list = hospitalDAO.selectHospitalByGradeId(id);
        return list;
    }
}
