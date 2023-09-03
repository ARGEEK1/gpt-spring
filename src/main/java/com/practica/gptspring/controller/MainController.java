package com.practica.gptspring.controller;

import com.practica.gptspring.dto.RequestDto;
import com.practica.gptspring.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @PostMapping("/chat")
    public ResponseEntity<List<ResponseDto.Choise>> chat (@RequestBody String prompt) {
        RequestDto requestDto = new RequestDto(model, prompt);
        ResponseDto responseDto = restTemplate.postForObject(apiUrl, requestDto, ResponseDto.class);
        if (requestDto == null || responseDto.getChoices() == null || responseDto.getChoices().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(responseDto.getChoices());
    }
}
