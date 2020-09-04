package com.ganwei.springcloud.service;

import com.ganwei.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
//    @Override
//    public Boolean addDept(Dept dept) {
//        System.out.println("addDept");
//        return null;
//    }
//
//    @Override
//    public Dept queryById(Long id) {
//        System.out.println("queryById");
//        return new Dept().setDeptno(id).setDname("该用户不存在").setDb_source("数据库不存在");
//    }
//
//    @Override
//    public List<Dept> queryAll() {
//        System.out.println("queryAll");
//
//        return null;
//    }
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Boolean addDept(Dept dept) {

                return null;
            }

            @Override
            public Dept queryById(Long id) {
                System.out.println("该服务被降级++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                Dept dept = new Dept().setDeptno(id).setDname("id=>"+id+"该服务被关闭").setDb_source("没有数据");
                return dept;
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
