package com.ganwei.springcloud.controller;

import com.ganwei.springcloud.pojo.Dept;
import com.ganwei.springcloud.server.DeptServer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供restful服务
 */
@RestController
public class DeptController {

    @Autowired
    private DeptServer deptServer;


    @HystrixCommand(fallbackMethod = "hystrixget")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        System.out.println("我是正常使用的方法");
        Dept dept = deptServer.queryById(id);
        if (dept == null) {
            throw new RuntimeException("id===>+" + id + "不存在");
        }
        return dept;
    }

    //备选方法
    public Dept hystrixget(@PathVariable("id") Long id) {
        System.out.println("我是备选方法"+id);

        Dept dept = new Dept().setDeptno(id).setDname("id=>"+id+"没有对应的信息").setDb_source("该数据库不存在");
        System.out.println("------------------------------------");
        return dept;

    }


}
