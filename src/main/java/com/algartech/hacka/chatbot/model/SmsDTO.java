package com.algartech.hacka.chatbot.model;

/**
 * Created by pauloho on 15/09/18.
 */
public class SmsDTO {
    private String phone;
    private String cpf;
    private String texto;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
