package com.practica.gptspring.dto;

import java.util.List;


public class ResponseDto {

    private List<Choice> choices;

    public ResponseDto() {
    }

    public ResponseDto(List<Choice> choices) {
        this.choices = choices;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "choices=" + choices +
                '}';
    }

    public static class Choice {

        private int index;

        private MessageDto message;

        public Choice() {
        }

        public Choice(MessageDto message, int index) {
            this.message = message;
            this.index = index;
        }

        public MessageDto getMessage() {
            return message;
        }

        public void setMessage(MessageDto message) {
            this.message = message;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "Choice{" +
                    "message=" + message +
                    ", index=" + index +
                    '}';
        }
    }
}