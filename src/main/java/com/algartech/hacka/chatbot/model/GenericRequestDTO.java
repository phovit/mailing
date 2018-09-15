package com.algartech.hacka.chatbot.model;

/**
 * Created by pauloho on 15/09/18.
 */
public class GenericRequestDTO {
    private String string;
    private Double valor;

    public GenericRequestDTO(String string) {
        this.string = string;
    }

    public GenericRequestDTO() {
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
