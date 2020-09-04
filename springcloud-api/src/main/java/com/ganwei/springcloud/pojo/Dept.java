package com.ganwei.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 实体类
 * @author 26782
 * @Accessors 链式写法
 */
@Data
@NoArgsConstructor
//链式写法
@Accessors(chain = true)
public class Dept implements Serializable {

    //主键
    private Long deptno;

    public Dept(Long deptno, String dname, String db_source) {
        this.deptno = deptno;
        this.dname = dname;
        this.db_source = db_source;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", db_source='" + db_source + '\'' +
                '}';
    }

    private String dname;

    //这个数据存在哪个数据库的字段~微服务 ，一个服务对应一个数据库，同一个消息可能存在不同的数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

/**
 * 链式写法
 * Dept dept = new Dept();
 * dept.setDeptNo(11).setDname(1111);
 */
}