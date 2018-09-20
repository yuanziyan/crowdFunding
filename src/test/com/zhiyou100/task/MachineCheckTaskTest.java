package com.zhiyou100.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author yuanziyan
 * @ClassName MachineCheckTaskTest
 * @Direction TODO
 * @data 2018/9/20 9:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-task.xml","classpath:spring.xml", "classpath:spring-mvc.xml"})
public class MachineCheckTaskTest {

    @Test
    public void realCheck() {

    }
}