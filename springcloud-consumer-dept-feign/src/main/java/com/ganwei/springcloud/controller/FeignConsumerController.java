package com.ganwei.springcloud.controller;


import com.ganwei.springcloud.pojo.Dept;
import com.ganwei.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.List;

@RestController
public class FeignConsumerController {
    /**
     * 消费者，不应该有service层
     * RestTempLate... 供我们直接调用就可以了，注册到spring中
     * <p>
     * (url,实体，Map,Class<T>responseType)
     *
     * restTemplate //提供多种便捷访问远程http服务的方法，简单的Restful服务模板
     */

    @Autowired
    private DeptClientService service;

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return this.service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        System.out.println(id+"++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            return this.service.queryById(id);

    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {

        return this.service.queryAll();
    }


}
