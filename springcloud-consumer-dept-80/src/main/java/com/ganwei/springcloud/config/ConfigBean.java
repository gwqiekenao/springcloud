package com.ganwei.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    /**
     * @Configuration--spring  applicationContext.xml
     * 配置负载均衡 Ribbon
     * IRule
     * RoundRobinRule 轮询
     * AvailabilityFilteringRule: 会先过滤掉，跳闸，访问故障的服务，对剩下的进行轮询
     * RetryRule:会先按照轮询获取服务，
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }



}
