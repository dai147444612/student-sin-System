package com.inet.drh;

import com.inet.drh.entity.po.Check;
import com.inet.drh.mapper.CheckMapper;
import com.inet.drh.service.ICheckService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    @Resource
    private CheckMapper checkMapper;

    @Test
    public void test2() {
        Check check = new Check();
        check.setStartTime(new Date());
        check.setId("1");
        check.setCheckState("0");
        checkMapper.singin(check);
        checkMapper.ManageSin(check);
    }


    @Test
    public void test1() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        long time = date.getTime();
//        long time2 = simpleDateFormat.parse(date).getTime();
        System.out.println(time);
    }


}
