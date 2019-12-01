package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Hospital implements Serializable {
    private String id;
    private String name;
    private Date birth;
    private Department department;
    private Grade grade;
    private String phone;
    private double salary;
}
