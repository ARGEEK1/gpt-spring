package com.practica.gptspring.dto;

public class PromptDto {
    private String prompt;

    public PromptDto() {
    }

    public PromptDto(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
