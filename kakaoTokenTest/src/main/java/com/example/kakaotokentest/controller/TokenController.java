package com.example.kakaotokentest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

@RestController
public class TokenController {

    @GetMapping("/kakao-login")
    public void getKakaoCode(@RequestParam String code) throws JsonProcessingException, IOException {
        String a = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=6d0a65635f44e3c97efa1ea6a5cc9865&redirect_uri=http://127.0.0.1:8081/kakao-login&response_type=code";
        System.out.println(code);
        getAccessToken(code);


    }

    public void getAccessToken(String code) throws JsonProcessingException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("https://kauth.kakao.com/oauth/token")
                .queryParam("client_id", "6d0a65635f44e3c97efa1ea6a5cc9865" )
                .queryParam("redirect_uri", "http://127.0.0.1:8081/kakao-login")
                .queryParam("code", code)
                .queryParam("grant_type", "authorization_code")
                .build().toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        HttpEntity<?> httpEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> res;

        res = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);

        System.out.println(res);


        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(res.getBody(), Map.class);

        System.out.println(map);

        String accessToken = map.get("access_token");
        String refreshToken = map.get("refresh_token");
        String accessTokenExpiresIn = map.get("expires_in");
        String refreshTokenExpiresIn = map.get("refresh_token_expires_in");



    }

}
