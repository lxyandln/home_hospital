package com.baizhi.service;

import com.baizhi.dao.GradeDAO;
import com.baizhi.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeDAO gradeDAO;

    @Override
    public void insertGrade(Grade grade) {
        String id = UUID.randomUUID().toString();
        grade.setId(id);
        gradeDAO.insertGrade(grade);
    }

    @Override
    public void deleteGrade(Grade grade) {
        gradeDAO.deleteGrade(grade);
    }

    @Override
    public void updateGrade(Grade grade) {
        gradeDAO.updateGrade(grade);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Grade> selectGradesPage(Integer page, Integer rows) {
        int start = (page - 1) * rows;
        List<Grade> list = gradeDAO.selectGradesPage(start, rows);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer selectGradeCount() {
        Integer count = gradeDAO.selectGradeCount();
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Grade> selectGradesAll() {
        List<Grade> list = gradeDAO.selectGradesAll();
        return list;
    }
}
