package com.ganwei.springcloud.controller;

import com.ganwei.springcloud.pojo.Dept;
import com.ganwei.springcloud.server.DeptServer;
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

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptServer.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDeptById(@PathVariable("id") long id){
        return deptServer.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> getDeptAll(){
        return deptServer.queryAll();
    }


    /**
     * 通过进来的微服务，获得一些消息
     */
    @GetMapping("/dept/doscovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>"+services);
        //得到一个具体的微服务信息,通过一个具体的微服务id，applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+"\t"+
                                instance.getPort()+"\t"+
                                instance.getUri()+"\t"+
                                instance.getServiceId());
        }
        return this.client;

    }
}
