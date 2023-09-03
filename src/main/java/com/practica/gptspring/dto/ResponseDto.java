package com.practica.gptspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private List<Choise> choises;

    public List<Choise> getChoices() {
        return  choises;
    }

    @Data
    public static class Choise {
        private MessageDto message;
        private int index;
    }
}