package com.practica.gptspring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MessageDto {
    private String role;
    private String content;

    public MessageDto(String role, String content) {
        this.role = role;
        this.content = content;
    }
}
