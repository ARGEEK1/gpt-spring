package com.practica.gptspring.dto;

import java.util.List;


public class ResponseDto {

    private List<Choise> choises;

    public  ResponseDto() {}

    public  ResponseDto(List<Choise> choises) {
        this.choises = choises;
    }
    public List<Choise> getChoices() {
        return  choises;
    }

    public void setChoises(List<Choise> choises) {
        this.choises = choises;
    }

    public static class Choise {
        private MessageDto message;
        private int index;

        public Choise () {}

        public Choise(MessageDto message, int index){
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
            return "Choise{" +
                    "message=" + message +
                    ", index=" + index +
                    '}';
        }
    }
}