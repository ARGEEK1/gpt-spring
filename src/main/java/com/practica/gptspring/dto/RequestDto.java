package com.practica.gptspring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class RequestDto {
    private String model;
    private List<MessageDto> messages;

    public RequestDto(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new MessageDto("user", prompt));
    }
}
