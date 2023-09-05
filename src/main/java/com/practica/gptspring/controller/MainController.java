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
    public ResponseEntity<MessageDto> chat(@RequestBody PromptDto prompt) {

        RequestDto requestDto = new RequestDto(model, prompt.getPrompt());
        requestDto.setN(1);
        requestDto.setTemperature(1);
        ResponseDto responseDto = restTemplate.postForObject(apiUrl, requestDto, ResponseDto.class);
        if (responseDto == null || responseDto.getChoices() == null || responseDto.getChoices().isEmpty()) {
            return ResponseEntity.badRequest().body(new MessageDto("assistant", "Fallo en la Consulta"));
        }
        return ResponseEntity.ok(responseDto.getChoices().get(0).getMessage());
    }
}