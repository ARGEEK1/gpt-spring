package com.practica.gptspring.dto;

import java.util.ArrayList;
import java.util.List;


public class RequestDto {
    private String model;
    private List<MessageDto> messages;
    private int n ;
    private double temperature;

    public RequestDto(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new MessageDto("user", prompt));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "ChatRequest{" +
                "model='" + model + '\'' +
                ", messages=" + messages +
                ", n=" + n +
                ", temperature=" + temperature +
                '}';
    }
}
