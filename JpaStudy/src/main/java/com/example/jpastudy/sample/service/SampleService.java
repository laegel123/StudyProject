package com.example.jpastudy.sample.service;

import com.example.jpastudy.sample.vo.SampleVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SampleService {
    private StringRedisTemplate redisTemplate;
    private ValueOperations redisString;

    public SampleService(StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = stringRedisTemplate;
        this.redisString = stringRedisTemplate.opsForValue();
    }

    public void save(SampleVO sampleVO) {
        redisString.set(sampleVO.getKey(), sampleVO.getValue());
    }

    public SampleVO get(String key) {
        String value = (String) redisString.get(key);
        if (value == null) {
            log.info("value if null");
            return null;
        }

        return new SampleVO(key, value);
    }




}
