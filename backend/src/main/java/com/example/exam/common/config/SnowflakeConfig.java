package com.example.exam.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.hutool.core.lang.Snowflake;

/**
 * @author zyimm
 */
@Configuration
public class SnowflakeConfig {
    
    @Value("${application.datacenterId}")
    private Long datacenterId;

    @Value("${application.workerId}")
    private Long workerId;

    @Bean
    public Snowflake snowflake() {
        return new Snowflake(workerId, datacenterId);
    }
}
