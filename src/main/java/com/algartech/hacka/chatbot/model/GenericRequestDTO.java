package com.algartech.hacka.chatbot.model;

/**
 * Created by pauloho on 15/09/18.
 */
public class GenericRequestDTO {
    private String formaNegociacao;

    public GenericRequestDTO(String formaNegociacao) {
        this.formaNegociacao = formaNegociacao;
    }

    public GenericRequestDTO() {
    }

    public String getFormaNegociacao() {
        return formaNegociacao;
    }

    public void setFormaNegociacao(String formaNegociacao) {
        this.formaNegociacao = formaNegociacao;
    }
}
