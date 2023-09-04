package com.practica.gptspring.controller;

import com.practica.gptspring.dto.RequestDto;
import com.practica.gptspring.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MainController {

    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {
        RequestDto requestDto = new RequestDto(model, prompt);
        requestDto.setN(1);
        requestDto.setTemperature(1);
        System.out.println("estoy aqui" + requestDto);
        ResponseDto responseDto = restTemplate.postForObject(apiUrl, requestDto, ResponseDto.class);
        System.out.println(responseDto.getChoices());
        if (responseDto == null || responseDto.getChoices() == null || responseDto.getChoices().isEmpty()) {
            //return ResponseEntity.badRequest().body(null);
            return "No response";
        }
        return responseDto.getChoices().get(0).getMessage().getContent();
    }
}