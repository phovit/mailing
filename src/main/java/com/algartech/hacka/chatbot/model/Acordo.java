package com.algartech.hacka.chatbot.model;

import java.util.Date;

/**
 * Created by pauloho on 15/09/18.
 */
public class Acordo {
    private Long idAcordo;
    private Date data_negociacao;
    private Float valor_entrada;
    private Date data_vencimento;
    private Float valor_parcelado;
    private Float valor_da_negociacao;


    public Long getIdAcordo() {
        return idAcordo;
    }

    public void setIdAcordo(Long idAcordo) {
        this.idAcordo = idAcordo;
    }

    public Date getData_negociacao() {
        return data_negociacao;
    }

    public void setData_negociacao(Date data_negociacao) {
        this.data_negociacao = data_negociacao;
    }

    public Float getValor_entrada() {
        return valor_entrada;
    }

    public void setValor_entrada(Float valor_entrada) {
        this.valor_entrada = valor_entrada;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Float getValor_parcelado() {
        return valor_parcelado;
    }

    public void setValor_parcelado(Float valor_parcelado) {
        this.valor_parcelado = valor_parcelado;
    }

    public Float getValor_da_negociacao() {
        return valor_da_negociacao;
    }

    public void setValor_da_negociacao(Float valor_da_negociacao) {
        this.valor_da_negociacao = valor_da_negociacao;
    }
}
