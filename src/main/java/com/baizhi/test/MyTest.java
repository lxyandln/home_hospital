package com.baizhi.test;

import com.baizhi.App;
import com.baizhi.dao.HospitalDAO;
import com.baizhi.entity.Hospital;
import com.baizhi.service.HospitalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class MyTest {
    @Autowired
    private HospitalDAO hospitalDAO;
    @Autowired
    private HospitalService hospitalService;

    @Test
    public void test1() {
        List<Hospital> list = hospitalDAO.selectHospitalsAll(0, 1);
        for (Hospital hospital : list) {
            System.out.println(hospital);
        }
    }

    @Test
    public void test2() {
        Integer count = hospitalService.selectHospitalCount();
        long total = (count - 1) / 2 + 1;
        System.out.println("count:" + count);
        System.out.println("total:" + total);
    }

    @Test
    public void test3() {
        List<Hospital> hospitals = hospitalService.selectHospitalByDepartmentId("1");
        System.out.println(hospitals.size());
        System.out.println("list2:" + "".equals(hospitals));
        System.out.println("list3:" + "[]".equals(hospitals));
        for (Hospital hospital : hospitals) {
            System.out.println("进入循环");
            System.out.println("hospital:" + hospital);
        }
        System.out.println("list1:" + hospitals == null);
        System.out.println("list2:" + "".equals(hospitals));
        System.out.println("list3:" + "[]".equals(hospitals));
    }
}
