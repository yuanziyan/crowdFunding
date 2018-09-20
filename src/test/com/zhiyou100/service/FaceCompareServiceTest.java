package com.zhiyou100.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author yuanziyan
 * @ClassName FaceCompareServiceTest
 * @Direction TODO
 * @data 2018/9/20 14:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class FaceCompareServiceTest {
    @Autowired
    FaceCompareService faceCompareService;
    @Test
    public void compare() {
        boolean compare = faceCompareService.compare("https://funding.oss-cn-beijing.aliyuncs.com/lyf1.jpeg", "https://funding.oss-cn-beijing.aliyuncs.com/lyf2.jpeg");
        System.out.println(compare);

    }
}