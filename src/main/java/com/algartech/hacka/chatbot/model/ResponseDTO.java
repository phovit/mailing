package com.algartech.hacka.chatbot.model;

/**
 * Created by pauloho on 15/09/18.
 */
public class ResponseDTO {
    private String data;

    public ResponseDTO(String data) {
        this.data = data;
    }

    public ResponseDTO() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
