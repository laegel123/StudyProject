package com.example.springstudy.aop.annotationcode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AOPController {

    @GetMapping("/test")
    @LogGetDate
    public ResponseEntity<String> signup() {
        String message = "테스트입니다.";
        return ResponseEntity.ok(message);
    }

}
