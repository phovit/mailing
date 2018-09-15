package com.algartech.hacka.chatbot.model;

/**
 * Created by pauloho on 15/09/18.
 */
public class Desconto {
    private Integer idtabela_desconto;
    private Float percentual_desconto_faixa;
    private Float valor_a_vista_com_desconto;
    private Float valor_a_prazo_com_desconto;

    public Integer getIdtabela_desconto() {
        return idtabela_desconto;
    }

    public void setIdtabela_desconto(Integer idtabela_desconto) {
        this.idtabela_desconto = idtabela_desconto;
    }

    public Float getPercentual_desconto_faixa() {
        return percentual_desconto_faixa;
    }

    public void setPercentual_desconto_faixa(Float percentual_desconto_faixa) {
        this.percentual_desconto_faixa = percentual_desconto_faixa;
    }

    public Float getValor_a_vista_com_desconto() {
        return valor_a_vista_com_desconto;
    }

    public void setValor_a_vista_com_desconto(Float valor_a_vista_com_desconto) {
        this.valor_a_vista_com_desconto = valor_a_vista_com_desconto;
    }

    public Float getValor_a_prazo_com_desconto() {
        return valor_a_prazo_com_desconto;
    }

    public void setValor_a_prazo_com_desconto(Float valor_a_prazo_com_desconto) {
        this.valor_a_prazo_com_desconto = valor_a_prazo_com_desconto;
    }
}
