package com.example.jpastudy.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring.data.redis")
@Configuration
public class RedisInfo {
    private String nodes;
    private String password;
    private String readFrom;
    private String clientName;
    private RedisInfo cluster;
}
