package com.example.designpattern.decorator.example2.controller;

import com.example.designpattern.decorator.example2.config.LowerCaseInputStream;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class LowerCaseController {

    @GetMapping("/lowerCase")
    public ResponseEntity<String> order() {
        int c;

        try {
            File file = ResourceUtils.getFile("classpath:test.txt");
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(file)));

            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return ResponseEntity.ok("test");
    }
}
