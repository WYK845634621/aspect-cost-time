package com.yikai.aspectcosttime.service.impl;

import com.yikai.aspectcosttime.annotations.Timer;
import com.yikai.aspectcosttime.service.TestService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/4/14 19:29
 */
@Service
public class TestServiceImpl implements TestService {


    @Timer
    @Override
    public void costTime() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Timer
    @Override
    public void pass() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
