package com.baizhi.dao;

import com.baizhi.entity.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeDAO {
    void insertGrade(Grade grade);

    void deleteGrade(Grade grade);

    void updateGrade(Grade grade);

    List<Grade> selectGradesPage(@Param(value = "start") int start, @Param(value = "rows") int rows);

    Integer selectGradeCount();

    List<Grade> selectGradesAll();
}
