package com.practica.gptspring.controller;

import com.practica.gptspring.dto.MessageDto;
import com.practica.gptspring.dto.PromptDto;
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

    @PostMapping("/chat")
    public ResponseEntity<List> chat(@RequestBody PromptDto prompt) {

        RequestDto requestDto = new RequestDto(model, prompt.getPrompt());
        requestDto.setN(1);
        requestDto.setTemperature(1);
        System.out.println("estoy aqui" + requestDto);
        ResponseDto responseDto = restTemplate.postForObject(apiUrl, requestDto, ResponseDto.class);
        System.out.println(responseDto.getChoices().get(0));
        if (responseDto == null || responseDto.getChoices() == null || responseDto.getChoices().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
            //return "No response";
        }
        return ResponseEntity.ok(responseDto.getChoices());
    }
}