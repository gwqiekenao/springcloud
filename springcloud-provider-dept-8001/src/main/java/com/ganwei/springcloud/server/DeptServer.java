package com.ganwei.springcloud.server;

import com.ganwei.springcloud.pojo.Dept;

import java.util.List;

public interface DeptServer {

    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();
}
