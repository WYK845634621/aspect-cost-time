package com.yikai.aspectcosttime.web;

import com.yikai.aspectcosttime.annotations.Timer;
import com.yikai.aspectcosttime.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/4/14 19:25
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/time")
    @Timer
    public String time(){
        try {
            TimeUnit.SECONDS.sleep(5);
            testService.costTime();
            testService.pass();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
