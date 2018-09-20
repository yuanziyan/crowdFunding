package com.zhiyou100.task;

import com.zhiyou100.entity.RealCheckEntity;
import com.zhiyou100.exception.CrowdFundingException;
import com.zhiyou100.service.FaceCompareService;
import com.zhiyou100.service.RealCheckService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuanziyan
 * @ClassName MachineCheckController
 * @Direction TODO
 * @data 2018/9/19 21:51
 */
@Component
public class MachineCheckTask {
    @Autowired
    RealCheckService realCheckService;
    @Autowired
    FaceCompareService faceCompareService;
    //定时从数据库中拿到未实名认证成功的记录,获得用户，得到他的身份证正面照，及手持身份证照
    //调用人脸识别接口，返回比对结果，如果成功，向用户发送邮件
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring-task.xml");
    }


    public void realCheck() throws CrowdFundingException {
        ExecutorService pool = Executors.newCachedThreadPool();

        List<RealCheckEntity> realCheckEntityList = realCheckService.unRealChecked(1);
        if (realCheckEntityList.size() > 0) {
            for (final RealCheckEntity realCheck:
                    realCheckEntityList  ) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    RealCheckEntity realCheckEntity = realCheck;
                    int id = realCheckEntity.getId();
                    String idCardHand = realCheckEntity.getIdCardHand();
                    String idCardNegative = realCheckEntity.getIdCardNegative();
                    boolean compare = faceCompareService.compare(idCardHand, idCardNegative);
                    if (compare) {
                        try {
                            realCheckService.manualRealCheck("success", id);
                        } catch (CrowdFundingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            }
        }else if (realCheckEntityList.size()==0){
            return;
        }
    }
}