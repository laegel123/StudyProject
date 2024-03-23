package com.example.kakaotokentest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

@RestController
public class TokenController {

    @GetMapping("/kakao/oauth")
    public void getKakaoCode(@RequestParam String code) throws JsonProcessingException, IOException {
        //String a = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=a176d73dee226e3de5ce00fbbaa98dc6&redirect_uri=http://localhost:8080/kakao/oauth&response_type=code";
        System.out.println(code);
        getAccessToken(code);


    }

    public void getAccessToken(String code) throws JsonProcessingException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("https://kauth.kakao.com/oauth/token")
                .queryParam("client_id", "a176d73dee226e3de5ce00fbbaa98dc6" )
                .queryParam("redirect_uri", "http://localhost:8080/kakao/oauth")
                .queryParam("code", code)
                .queryParam("grant_type", "authorization_code")
                .build().toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
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
        int accessTokenExpiresIn = Integer.parseInt(String.valueOf(map.get("expires_in")));
        int refreshTokenExpiresIn = Integer.parseInt(String.valueOf(map.get("refresh_token_expires_in")));
        LocalDateTime accessDatetime = LocalDateTime.now().plusSeconds(
                accessTokenExpiresIn);

        LocalDateTime refreshDatetime = LocalDateTime.now().plusSeconds(
                refreshTokenExpiresIn);

        System.out.println(refreshDatetime);


    }

    @GetMapping("/tokenTest")
    public void tokenTest() throws URISyntaxException {
        URI uri = new URI(
                "https://kauth.kakao.com/oauth/authorize?client_id="+"6d0a65635f44e3c97efa1ea6a5cc9865"+
                        "&redirect_uri=http://127.0.0.1:8081/kakao-login");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =  restTemplate.getForEntity(uri, String.class);

        String code = "";
        //String code = StringUtils.substringBetween(response.getBody(), "code :");

        String str = response.getBody();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("grant_type", Arrays.asList("authorization_code"));
        params.put("client_id", Arrays.asList("6d0a65635f44e3c97efa1ea6a5cc9865"));
        params.put("redirect_uri", Arrays.asList("http://127.0.0.1:8081/kakao-login"));
        params.put("code", Arrays.asList(code));

        UriComponents kakaoOauthTokenUriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("kauth.kakao.com")
                .path("/oauth/token")
                .queryParams(params)
                .build();

        ResponseEntity<String> kakaoOauthTokenResponse =
                restTemplate.exchange(kakaoOauthTokenUriComponents.toString(), HttpMethod.POST, entity, String.class);

        System.out.println(kakaoOauthTokenResponse);
    }

}
