package com.example.jpastudy.sample.web;

import com.example.jpastudy.sample.service.SampleService;
import com.example.jpastudy.sample.vo.SampleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class SampleController {

    private final SampleService sampleService;

    @PostMapping("string")
    public SampleVO saveString(@RequestBody SampleVO sampleVO) {
        sampleService.save(sampleVO);
        return sampleVO;
    }

    @GetMapping("string/{key}")
    public SampleVO get(@PathVariable("key") String key) {
        return sampleService.get(key);
    }
}
