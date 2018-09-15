package com.algartech.hacka.chatbot.model;

/**
 * Created by pauloho on 15/09/18.
 */
public class EmailDTO {
    private String assunto;
    private String conteudo;
    private String email;

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
