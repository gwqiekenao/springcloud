package com.ganwei.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GanweiRule {

    @Bean
    public IRule myiRule(){
        return new RandomRule();
    }
}
