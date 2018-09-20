package com.zhiyou100.service;

import com.aliyun.oss.model.PutObjectResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class OSSServiceTest {

    @Autowired
    OSSService ossService;
    @Test
    public void upload() throws FileNotFoundException {
        String url = ossService.upload("funding","lyf3.jpeg",new FileInputStream(new File("e:\\images\\3.jpeg")));
        String ur2 = ossService.upload("funding","lyf4.jpeg",new FileInputStream(new File("e:\\images\\4.jpeg")));
        String ur3 = ossService.upload("funding","lyf5.jpeg",new FileInputStream(new File("e:\\images\\5.jpeg")));
    }
    @Test
    public void download(){
        ossService.downLoad("crowdfundingweb","do.jpeg","d:\\test\\img.jpeg");
    }

}