package com.baizhi.service;

import com.baizhi.entity.Grade;

import java.util.List;

public interface GradeService {
    void insertGrade(Grade grade);

    void deleteGrade(Grade grade);

    void updateGrade(Grade grade);

    List<Grade> selectGradesPage(Integer page, Integer rows);

    Integer selectGradeCount();

    List<Grade> selectGradesAll();
}
